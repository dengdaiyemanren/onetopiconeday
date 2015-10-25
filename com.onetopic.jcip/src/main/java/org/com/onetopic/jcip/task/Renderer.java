package org.com.onetopic.jcip.task;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.com.onetopic.jcip.safecollections.synchronizer.LaunderThrowable;

/**
 * Renderer
 * <p/>
 * Using CompletionService to render page elements as they become available
 *
 * @author Brian Goetz and Tim Peierls
 */
public abstract class Renderer
{
    private final ExecutorService executor;
    
    Renderer(ExecutorService executor)
    {
        this.executor = executor;
    }
    
    void renderPage(CharSequence source)
    {
        final List<ImageInfo> info = scanForImageInfo(source);
        CompletionService<ImageData> completionService = new ExecutorCompletionService<ImageData>(executor);
        for (final ImageInfo imageInfo : info)
            completionService.submit(new Callable<ImageData>()
            {
                public ImageData call()
                {
                    return imageInfo.downloadImage();
                }
            });
        
        renderText(source);
        
        try
        {
            for (int t = 0, n = info.size(); t < n; t++)
            {
                Future<ImageData> f = completionService.take();
                ImageData imageData = f.get();
                renderImage(imageData);
            }
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        catch (ExecutionException e)
        {
            throw LaunderThrowable.launderThrowable(e.getCause());
        }
    }
    
    interface ImageData
    {
    }
    
    interface ImageInfo
    {
        ImageData downloadImage();
    }
    
    abstract void renderText(CharSequence s);
    
    abstract List<ImageInfo> scanForImageInfo(CharSequence s);
    
    abstract void renderImage(ImageData i);
    
}