/*
 * The MIT License
 *
 * Copyright (c) 2016, CloudBees, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.jenkinsci.plugins.pipeline.modeldefinition.agent.impl;

import hudson.Extension;
import org.jenkinsci.Symbol;
import org.jenkinsci.plugins.pipeline.modeldefinition.agent.DeclarativeAgent;
import org.jenkinsci.plugins.pipeline.modeldefinition.agent.DeclarativeAgentDescriptor;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.DataBoundSetter;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

public class DockerPipelineFromDockerfile extends DeclarativeAgent<DockerPipelineFromDockerfile> {
    private String label;
    private Object dockerfile;
    private String dockerArgs = "";

    @DataBoundConstructor
    public DockerPipelineFromDockerfile(@Nonnull Object dockerfile) {
        this.dockerfile = dockerfile;
    }

    public @CheckForNull String getLabel() {
        return label;
    }

    @DataBoundSetter
    public void setLabel(String label) {
        this.label = label;
    }

    public @CheckForNull String getDockerArgs() {
        return dockerArgs;
    }

    @DataBoundSetter
    public void setDockerArgs(String dockerArgs) {
        this.dockerArgs = dockerArgs;
    }

    public @Nonnull Object getDockerfile() {
        return dockerfile;
    }

    public String getDockerfileAsString() {
        if (dockerfile instanceof String) {
            return (String)dockerfile;
        } else {
            return "Dockerfile";
        }
    }

    @Extension(ordinal = 999) @Symbol("dockerfile")
    public static class DescriptorImpl extends DeclarativeAgentDescriptor<DockerPipelineFromDockerfile> {
    }
}
