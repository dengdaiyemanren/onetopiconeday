package org.com.onetopic.hellomavenplugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

public class HelloMojo extends AbstractMojo
{
    public void execute() throws MojoExecutionException, MojoFailureException
    {
        getLog().info("Hello World!");
    }
    
}
