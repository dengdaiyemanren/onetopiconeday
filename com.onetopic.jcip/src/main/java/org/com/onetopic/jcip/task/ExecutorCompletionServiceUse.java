package org.com.onetopic.jcip.task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;

public class ExecutorCompletionServiceUse
{
    /**
     * 假定您有针对某个问题的一组求解程序，每个求解程序都能返回某种类型的 Result 值，
     * 并且您想同时运行它们，使用方法 use(Result r) 处理返回非 null
     * 值的每个求解程序的返回结果。
     * 
     * @param e
     * @param solvers
     * @throws InterruptedException
     * @throws ExecutionException
     */
    void solve1(Executor e, Collection<Callable<Result>> solvers) throws InterruptedException, ExecutionException
    {
        CompletionService<Result> ecs = new ExecutorCompletionService<Result>(e);
        for (Callable<Result> s : solvers)
            ecs.submit(s);
        int n = solvers.size();
        for (int i = 0; i < n; ++i)
        {
            Result r = ecs.take().get();
            if (r != null)
            {
                // use(r);
            }
            
        }
    }
    
    /**
     * 假定您想使用任务集中的第一个非 null 结果，
     * 而忽略任何遇到异常的任务，并且在第一个任务就绪时取消其他所有任务
     * 
     * @param e
     * @param solvers
     * @throws InterruptedException
     */
    void solve2(Executor e, Collection<Callable<Result>> solvers) throws InterruptedException
    {
        CompletionService<Result> ecs = new ExecutorCompletionService<Result>(e);
        int n = solvers.size();
        List<Future<Result>> futures = new ArrayList<Future<Result>>(n);
        Result result = null;
        try
        {
            for (Callable<Result> s : solvers)
                futures.add(ecs.submit(s));
            for (int i = 0; i < n; ++i)
            {
                try
                {
                    Result r = ecs.take().get();
                    if (r != null)
                    {
                        result = r;
                        break;
                    }
                }
                catch (ExecutionException ignore)
                {
                }
            }
        }
        finally
        {
            for (Future<Result> f : futures)
                f.cancel(true);
        }
        
        if (result != null)
        {
            // use(result);
        }
        
    }
    
}

class Result
{
    
}
