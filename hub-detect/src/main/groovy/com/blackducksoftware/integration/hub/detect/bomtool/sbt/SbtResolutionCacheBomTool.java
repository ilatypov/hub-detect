/**
 * hub-detect
 *
 * Copyright (C) 2018 Black Duck Software, Inc.
 * http://www.blackducksoftware.com/
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.blackducksoftware.integration.hub.detect.bomtool.sbt;

import java.io.File;

import com.blackducksoftware.integration.hub.detect.bomtool.BomTool;
import com.blackducksoftware.integration.hub.detect.bomtool.BomToolEnvironment;
import com.blackducksoftware.integration.hub.detect.bomtool.BomToolGroupType;
import com.blackducksoftware.integration.hub.detect.bomtool.BomToolType;
import com.blackducksoftware.integration.hub.detect.bomtool.ExtractionId;
import com.blackducksoftware.integration.hub.detect.util.DetectFileFinder;
import com.blackducksoftware.integration.hub.detect.workflow.bomtool.BomToolResult;
import com.blackducksoftware.integration.hub.detect.workflow.bomtool.FileNotFoundBomToolResult;
import com.blackducksoftware.integration.hub.detect.workflow.bomtool.PassedBomToolResult;
import com.blackducksoftware.integration.hub.detect.workflow.extraction.Extraction;

public class SbtResolutionCacheBomTool extends BomTool {
    public static final String BUILD_SBT_FILENAME = "build.sbt";

    private final DetectFileFinder fileFinder;
    private final SbtResolutionCacheExtractor sbtResolutionCacheExtractor;

    public SbtResolutionCacheBomTool(final BomToolEnvironment environment, final DetectFileFinder fileFinder, final SbtResolutionCacheExtractor sbtResolutionCacheExtractor) {
        super(environment, "Build SBT", BomToolGroupType.SBT, BomToolType.SBT_RESOLUTION_CACHE);
        this.fileFinder = fileFinder;
        this.sbtResolutionCacheExtractor = sbtResolutionCacheExtractor;
    }

    @Override
    public BomToolResult applicable() {
        final File build = fileFinder.findFile(environment.getDirectory(), BUILD_SBT_FILENAME);
        if (build == null) {
            return new FileNotFoundBomToolResult(BUILD_SBT_FILENAME);
        }

        return new PassedBomToolResult();
    }

    @Override
    public BomToolResult extractable() {
        return new PassedBomToolResult();
    }

    @Override
    public Extraction extract(final ExtractionId extractionId) {
        return sbtResolutionCacheExtractor.extract(this.getBomToolType(), environment.getDirectory());
    }

}
