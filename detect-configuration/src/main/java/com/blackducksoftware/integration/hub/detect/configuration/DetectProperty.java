/**
 * detect-configuration
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
package com.blackducksoftware.integration.hub.detect.configuration;

import static com.blackducksoftware.integration.hub.detect.configuration.DetectProperty.PropertyConstants.*;

import com.blackducksoftware.integration.hub.detect.help.AcceptableValues;
import com.blackducksoftware.integration.hub.detect.help.HelpDescription;
import com.blackducksoftware.integration.hub.detect.help.HelpDetailed;
import com.blackducksoftware.integration.hub.detect.help.HelpGroup;
import com.blackducksoftware.integration.hub.detect.help.ValueDeprecation;

public enum DetectProperty {

    // insert here

    @HelpGroup(primary = GROUP_GENERAL)
    @HelpDescription("If true, Detect will fail if there are any issues found in the configuration.")
    DETECT_FAIL_CONFIG_WARNING("detect.fail.config.warning", DetectPropertyType.BOOLEAN, "true"),

    @HelpGroup(primary = GROUP_GENERAL)
    @HelpDescription("If true, detect will always exit with code 0.")
    DETECT_FORCE_SUCCESS("detect.force.success", DetectPropertyType.BOOLEAN, "false"),

    @HelpGroup(primary = GROUP_LOGGING)
    @HelpDescription("If true, the default behavior of printing your configuration properties at startup will be suppressed.")
    DETECT_SUPPRESS_CONFIGURATION_OUTPUT("detect.suppress.configuration.output", DetectPropertyType.BOOLEAN, "false"),

    @HelpGroup(primary = GROUP_LOGGING)
    @HelpDescription("If true, the default behavior of printing the Detect Results will be suppressed.")
    DETECT_SUPPRESS_RESULTS_OUTPUT("detect.suppress.results.output", DetectPropertyType.BOOLEAN, "false"),

    @HelpGroup(primary = GROUP_CLEANUP)
    @HelpDescription("If true the files created by Detect will be cleaned up.")
    DETECT_CLEANUP("detect.cleanup", DetectPropertyType.BOOLEAN, "true"),

    @HelpGroup(primary = GROUP_HUB_CONFIGURATION, additional = { SEARCH_GROUP_HUB })
    @HelpDescription("Test the connection to the Hub with the current configuration")
    DETECT_TEST_CONNECTION("detect.test.connection", DetectPropertyType.BOOLEAN, "false"),

    @HelpGroup(primary = GROUP_PROJECT_INFO, additional = { SEARCH_GROUP_PROJECT })
    @HelpDescription("Timeout for response from the hub regarding your project (i.e. risk reports and policy check). When changing this value, keep in mind the checking of policies might have to wait for a new scan to process which can take some time.")
    DETECT_API_TIMEOUT("detect.api.timeout", DetectPropertyType.LONG, "300000"),

    @HelpGroup(primary = GROUP_HUB_CONFIGURATION, additional = { SEARCH_GROUP_HUB })
    @HelpDescription("URL of the Hub server")
    BLACKDUCK_HUB_URL("blackduck.hub.url", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_HUB_CONFIGURATION, additional = { SEARCH_GROUP_HUB })
    @HelpDescription("Time to wait for rest connections to complete")
    BLACKDUCK_HUB_TIMEOUT("blackduck.hub.timeout", DetectPropertyType.INTEGER, "120"),

    @HelpGroup(primary = GROUP_HUB_CONFIGURATION, additional = { SEARCH_GROUP_HUB })
    @HelpDescription("Hub username")
    BLACKDUCK_HUB_USERNAME("blackduck.hub.username", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_HUB_CONFIGURATION, additional = { SEARCH_GROUP_HUB })
    @HelpDescription("Hub password")
    BLACKDUCK_HUB_PASSWORD("blackduck.hub.password", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_HUB_CONFIGURATION, additional = { SEARCH_GROUP_HUB })
    @HelpDescription("Hub API Token")
    BLACKDUCK_HUB_API_TOKEN("blackduck.hub.api.token", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_HUB_CONFIGURATION, additional = { SEARCH_GROUP_HUB, SEARCH_GROUP_PROXY })
    @HelpDescription("Proxy host")
    BLACKDUCK_HUB_PROXY_HOST("blackduck.hub.proxy.host", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_HUB_CONFIGURATION, additional = { SEARCH_GROUP_HUB, SEARCH_GROUP_PROXY })
    @HelpDescription("Proxy port")
    BLACKDUCK_HUB_PROXY_PORT("blackduck.hub.proxy.port", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_HUB_CONFIGURATION, additional = { SEARCH_GROUP_HUB, SEARCH_GROUP_PROXY })
    @HelpDescription("Proxy username")
    BLACKDUCK_HUB_PROXY_USERNAME("blackduck.hub.proxy.username", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_HUB_CONFIGURATION, additional = { SEARCH_GROUP_HUB, SEARCH_GROUP_PROXY })
    @HelpDescription("Proxy password")
    BLACKDUCK_HUB_PROXY_PASSWORD("blackduck.hub.proxy.password", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_HUB_CONFIGURATION, additional = { SEARCH_GROUP_HUB, SEARCH_GROUP_PROXY })
    @HelpDescription("Ntlm Proxy domain")
    BLACKDUCK_HUB_PROXY_NTLM_DOMAIN("blackduck.hub.proxy.ntlm.domain", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_HUB_CONFIGURATION, additional = { SEARCH_GROUP_HUB, SEARCH_GROUP_PROXY })
    @HelpDescription("Comma separated list of host patterns that should not use the proxy")
    BLACKDUCK_HUB_PROXY_IGNORED_HOSTS("blackduck.hub.proxy.ignored.hosts", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_HUB_CONFIGURATION, additional = { SEARCH_GROUP_HUB, SEARCH_GROUP_PROXY })
    @HelpDescription("Ntlm Proxy workstation")
    BLACKDUCK_HUB_PROXY_NTLM_WORKSTATION("blackduck.hub.proxy.ntlm.workstation", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_HUB_CONFIGURATION, additional = { SEARCH_GROUP_HUB })
    @HelpDescription("If true, automatically trust the certificate for the current run of Detect only")
    BLACKDUCK_HUB_TRUST_CERT("blackduck.hub.trust.cert", DetectPropertyType.BOOLEAN, "false"),

    @HelpGroup(primary = GROUP_HUB_CONFIGURATION, additional = { SEARCH_GROUP_HUB, SEARCH_GROUP_OFFLINE })
    @HelpDescription("This can disable any Hub communication - if true, Detect will not upload BDIO files, it will not check policies, and it will not download and install the signature scanner.")
    BLACKDUCK_HUB_OFFLINE_MODE("blackduck.hub.offline.mode", DetectPropertyType.BOOLEAN, "false"),

    @HelpGroup(primary = GROUP_HUB_CONFIGURATION, additional = { SEARCH_GROUP_HUB })
    @HelpDescription("If true, during initialization Detect will check for Hub connectivity and exit with status code 0 if it cannot connect.")
    DETECT_DISABLE_WITHOUT_HUB("detect.disable.without.hub", DetectPropertyType.BOOLEAN, "false"),

    @HelpGroup(primary = GROUP_PATHS)
    @HelpDescription("If set to false we will not automatically resolve the '~/' prefix in a mac or linux path to the user's home directory.")
    DETECT_RESOLVE_TILDE_IN_PATHS("detect.resolve.tilde.in.paths", DetectPropertyType.BOOLEAN, "true"),

    @HelpGroup(primary = GROUP_PATHS)
    @HelpDescription("Source path to inspect")
    DETECT_SOURCE_PATH("detect.source.path", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_PATHS)
    @HelpDescription("Output path")
    DETECT_OUTPUT_PATH("detect.output.path", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_PATHS)
    @HelpDescription("The output directory for all bdio files. If not set, the bdio files will be in a 'bdio' subdirectory of the output path.")
    DETECT_BDIO_OUTPUT_PATH("detect.bdio.output.path", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_PATHS, additional = { SEARCH_GROUP_SIGNATURE_SCANNER, SEARCH_GROUP_HUB })
    @HelpDescription("The output directory for all scan files. If not set, the scan files will be in a 'scan' subdirectory of the output path.")
    DETECT_SCAN_OUTPUT_PATH("detect.scan.output.path", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_PATHS)
    @HelpDescription("Depth from source paths to search for files.")
    DETECT_SEARCH_DEPTH("detect.search.depth", DetectPropertyType.INTEGER, "3"),

    @HelpGroup(primary = GROUP_PATHS, additional = { GROUP_BOMTOOL, SEARCH_GROUP_SEARCH })
    @HelpDescription("The bom tool to choose when multiple bom tool types are found and one needs to be chosen for project name and version.")
    DETECT_PROJECT_BOM_TOOL("detect.project.bom.tool", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_PATHS, additional = { GROUP_BOMTOOL, SEARCH_GROUP_SEARCH })
    @HelpDescription("Depth from source paths to search for files to determine if a bom tool applies.")
    DETECT_BOM_TOOL_SEARCH_DEPTH("detect.bom.tool.search.depth", DetectPropertyType.INTEGER, "0"),

    @HelpGroup(primary = GROUP_PATHS, additional = { GROUP_BOMTOOL, SEARCH_GROUP_SEARCH })
    @HelpDescription("If true, the bom tool search will continue to look for nested bom tools of the same type to the maximum search depth, see the detailed help for more information.")
    @HelpDetailed("If true, Detect will find Maven projects that are in subdirectories of a Maven project and Gradle projects that are in subdirectories of Gradle projects, etc.\r\nIf false, Detect will only find bom tools in subdirectories of a project if they are of a different type such as an Npm project in a subdirectory of a Gradle project.")
    DETECT_BOM_TOOL_SEARCH_CONTINUE("detect.bom.tool.search.continue", DetectPropertyType.BOOLEAN, "false"),

    @HelpGroup(primary = GROUP_PATHS, additional = { GROUP_BOMTOOL, SEARCH_GROUP_SEARCH })
    @HelpDescription("A comma-separated list of directory names to exclude from the bom tool search.")
    DETECT_BOM_TOOL_SEARCH_EXCLUSION("detect.bom.tool.search.exclusion", DetectPropertyType.STRING_ARRAY),

    @HelpGroup(primary = GROUP_PATHS, additional = { GROUP_BOMTOOL, SEARCH_GROUP_SEARCH })
    @HelpDescription("If true, the bom tool search will exclude the default directory names. See the detailed help for more information.")
    @HelpDetailed("If true, these directories will be excluded from the bom tool search: " + BomToolSearchExcludedDirectories.DIRECTORY_NAMES)
    DETECT_BOM_TOOL_SEARCH_EXCLUSION_DEFAULTS("detect.bom.tool.search.exclusion.defaults", DetectPropertyType.BOOLEAN, "true"),

    @HelpGroup(primary = GROUP_BOMTOOL, additional = { SEARCH_GROUP_SEARCH })
    @HelpDescription("By default, all tools will be included. If you want to exclude specific tools, specify the ones to exclude here. Exclusion rules always win.")
    DETECT_EXCLUDED_BOM_TOOL_TYPES("detect.excluded.bom.tool.types", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_BOMTOOL, additional = { SEARCH_GROUP_SEARCH })
    @HelpDescription("By default, all tools will be included. If you want to include only specific tools, specify the ones to include here. Exclusion rules always win.")
    DETECT_INCLUDED_BOM_TOOL_TYPES("detect.included.bom.tool.types", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_PROJECT_INFO, additional = { SEARCH_GROUP_PROJECT })
    @HelpDescription("An override for the name detect will use for the code location it creates. If supplied and multiple code locations are found, detect will append an index to each code location name.")
    DETECT_CODE_LOCATION_NAME("detect.code.location.name", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_PROJECT_INFO, additional = { SEARCH_GROUP_PROJECT })
    @HelpDescription("An override for the name to use for the Hub project. If not supplied, detect will attempt to use the tools to figure out a reasonable project name. If that fails, the final part of the directory path where the inspection is taking place will be used.")
    DETECT_PROJECT_NAME("detect.project.name", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_PROJECT_INFO, additional = { SEARCH_GROUP_PROJECT })
    @HelpDescription("If project description is specified, your project version will be created with this description.")
    DETECT_PROJECT_DESCRIPTION("detect.project.description", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_PROJECT_INFO, additional = { SEARCH_GROUP_PROJECT })
    @HelpDescription("An override for the version to use for the Hub project. If not supplied, detect will attempt to use the tools to figure out a reasonable version name. If that fails, the current date will be used.")
    DETECT_PROJECT_VERSION_NAME("detect.project.version.name", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_PROJECT_INFO, additional = { SEARCH_GROUP_PROJECT })
    @HelpDescription("If project version notes are specified, your project version will be created with these notes.")
    DETECT_PROJECT_VERSION_NOTES("detect.project.version.notes", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_PROJECT_INFO, additional = { SEARCH_GROUP_PROJECT })
    @HelpDescription("If a hub project tier is specified, your project will be created with this tier.")
    @AcceptableValues(value = { "1", "2", "3", "4", "5" }, caseSensitive = false, strict = false)
    DETECT_PROJECT_TIER("detect.project.tier", DetectPropertyType.INTEGER),

    @HelpGroup(primary = GROUP_PROJECT_INFO, additional = { SEARCH_GROUP_PROJECT })
    @HelpDescription("A prefix to the name of the codelocations created by Detect. Useful for running against the same projects on multiple machines.")
    DETECT_PROJECT_CODELOCATION_PREFIX("detect.project.codelocation.prefix", DetectPropertyType.STRING, ""),

    @HelpGroup(primary = GROUP_PROJECT_INFO, additional = { SEARCH_GROUP_PROJECT })
    @HelpDescription("A suffix to the name of the codelocations created by Detect.")
    DETECT_PROJECT_CODELOCATION_SUFFIX("detect.project.codelocation.suffix", DetectPropertyType.STRING, ""),

    @HelpGroup(primary = GROUP_PROJECT_INFO, additional = { SEARCH_GROUP_PROJECT })
    @HelpDescription("If set to true, unmaps all other code locations mapped to the project version produced by the current run of Detect.")
    DETECT_PROJECT_CODELOCATION_UNMAP("detect.project.codelocation.unmap", DetectPropertyType.BOOLEAN, "false"),

    @HelpGroup(primary = GROUP_PROJECT_INFO, additional = { SEARCH_GROUP_PROJECT })
    @HelpDescription("An override for the Project level matches.")
    DETECT_PROJECT_LEVEL_ADJUSTMENTS("detect.project.level.adjustments", DetectPropertyType.BOOLEAN, "true"),

    @HelpGroup(primary = GROUP_PROJECT_INFO, additional = { SEARCH_GROUP_PROJECT })
    @HelpDescription("An override for the Project Version phase.")
    @AcceptableValues(value = { "PLANNING", "DEVELOPMENT", "RELEASED", "DEPRECATED", "ARCHIVED" }, caseSensitive = false, strict = false)
    DETECT_PROJECT_VERSION_PHASE("detect.project.version.phase", DetectPropertyType.STRING, "Development"),

    @HelpGroup(primary = GROUP_PROJECT_INFO, additional = { SEARCH_GROUP_PROJECT })
    @HelpDescription("An override for the Project Version distribution")
    @AcceptableValues(value = { "EXTERNAL", "SAAS", "INTERNAL", "OPENSOURCE" }, caseSensitive = false, strict = false)
    DETECT_PROJECT_VERSION_DISTRIBUTION("detect.project.version.distribution", DetectPropertyType.STRING, "External"),

    @HelpGroup(primary = GROUP_PROJECT_INFO, additional = { SEARCH_GROUP_PROJECT })
    @HelpDescription("If set to true, will update the Project Version with the configured properties. See detailed help for more information.")
    @HelpDetailed("When set to true, the following properties will be updated on the Project. Project tier (detect.project.tier) and Project Level Adjustments (detect.project.level.adjustments).\r\n The following properties will also be updated on the Version. Version notes (detect.project.version.notes), phase (detect.project.version.phase), distribution (detect.project.version.distribution)")
    DETECT_PROJECT_VERSION_UPDATE("detect.project.version.update", DetectPropertyType.BOOLEAN, "false"),

    @HelpGroup(primary = GROUP_POLICY_CHECK, additional = { SEARCH_GROUP_POLICY })
    @HelpDescription("A comma-separated list of policy violation severities that will fail detect. If this is not set, detect will not fail due to policy violations.")
    @AcceptableValues(value = { "ALL", "BLOCKER", "CRITICAL", "MAJOR", "MINOR", "TRIVIAL" }, caseSensitive = false, strict = false, isCommaSeparatedList = true)
    DETECT_POLICY_CHECK_FAIL_ON_SEVERITIES("detect.policy.check.fail.on.severities", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_GRADLE)
    @HelpDescription("Version of the Gradle Inspector")
    DETECT_GRADLE_INSPECTOR_VERSION("detect.gradle.inspector.version", DetectPropertyType.STRING, "latest"),

    @HelpGroup(primary = GROUP_GRADLE)
    @HelpDescription("Gradle build command")
    DETECT_GRADLE_BUILD_COMMAND("detect.gradle.build.command", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_GRADLE)
    @HelpDescription("The names of the dependency configurations to exclude")
    DETECT_GRADLE_EXCLUDED_CONFIGURATIONS("detect.gradle.excluded.configurations", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_GRADLE)
    @HelpDescription("The names of the dependency configurations to include")
    DETECT_GRADLE_INCLUDED_CONFIGURATIONS("detect.gradle.included.configurations", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_GRADLE)
    @HelpDescription("The names of the projects to exclude")
    DETECT_GRADLE_EXCLUDED_PROJECTS("detect.gradle.excluded.projects", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_GRADLE)
    @HelpDescription("The names of the projects to include")
    DETECT_GRADLE_INCLUDED_PROJECTS("detect.gradle.included.projects", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_NUGET)
    @HelpDescription("The path to the Nuget.Config file to supply to the nuget exe")
    DETECT_NUGET_CONFIG_PATH("detect.nuget.config.path", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_NUGET)
    @HelpDescription("Name of the Nuget Inspector")
    DETECT_NUGET_INSPECTOR_NAME("detect.nuget.inspector.name", DetectPropertyType.STRING, "IntegrationNugetInspector"),

    @HelpGroup(primary = GROUP_NUGET)
    @HelpDescription("Version of the Nuget Inspector")
    DETECT_NUGET_INSPECTOR_VERSION("detect.nuget.inspector.version", DetectPropertyType.STRING, "latest"),

    @HelpGroup(primary = GROUP_NUGET)
    @HelpDescription("The names of the projects in a solution to exclude")
    DETECT_NUGET_EXCLUDED_MODULES("detect.nuget.excluded.modules", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_NUGET)
    @HelpDescription("The names of the projects in a solution to include (overrides exclude)")
    DETECT_NUGET_INCLUDED_MODULES("detect.nuget.included.modules", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_NUGET)
    @HelpDescription("If true errors will be logged and then ignored.")
    DETECT_NUGET_IGNORE_FAILURE("detect.nuget.ignore.failure", DetectPropertyType.BOOLEAN, "false"),

    @HelpGroup(primary = GROUP_MAVEN)
    @HelpDescription("The name of the dependency scope to include")
    DETECT_MAVEN_SCOPE("detect.maven.scope", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_MAVEN)
    @HelpDescription("Maven build command")
    DETECT_MAVEN_BUILD_COMMAND("detect.maven.build.command", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_GRADLE)
    @HelpDescription("Path of the Gradle executable")
    DETECT_GRADLE_PATH("detect.gradle.path", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_MAVEN)
    @HelpDescription("The path of the Maven executable")
    DETECT_MAVEN_PATH("detect.maven.path", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_MAVEN)
    @HelpDescription("The names of the module to exclude")
    DETECT_MAVEN_EXCLUDED_MODULES("detect.maven.excluded.modules", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_MAVEN)
    @HelpDescription("The names of the module to include")
    DETECT_MAVEN_INCLUDED_MODULES("detect.maven.included.modules", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_NUGET)
    @HelpDescription("The path of the Nuget executable")
    DETECT_NUGET_PATH("detect.nuget.path", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_PIP)
    @ValueDeprecation(description = "detect.project.name will be used for this in the future", willRemoveInVersion = "5.0.0")
    @HelpDescription("The name of your pip project, to be used if your project's name cannot be correctly inferred from its setup.py file")
    DETECT_PIP_PROJECT_NAME("detect.pip.project.name", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_PIP)
    @ValueDeprecation(description = "detect.project.version.name will be used for this in the future", willRemoveInVersion = "5.0.0")
    @HelpDescription("The version of your pip project, to be used if your project's version name cannot be correctly inferred from its setup.py file")
    DETECT_PIP_PROJECT_VERSION_NAME("detect.pip.project.version.name", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_PYTHON)
    @HelpDescription("If true will use Python 3 if available on class path")
    DETECT_PYTHON_PYTHON3("detect.python.python3", DetectPropertyType.BOOLEAN, "false"),

    @HelpGroup(primary = GROUP_PYTHON)
    @HelpDescription("The path of the Python executable")
    DETECT_PYTHON_PATH("detect.python.path", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_PIP)
    @HelpDescription("The path of the Pipenv executable")
    DETECT_PIPENV_PATH("detect.pipenv.path", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_NPM)
    @HelpDescription("The path of the Npm executable")
    DETECT_NPM_PATH("detect.npm.path", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_NPM)
    @HelpDescription("Set this value to false if you would like to exclude your dev dependencies when ran")
    DETECT_NPM_INCLUDE_DEV_DEPENDENCIES("detect.npm.include.dev.dependencies", DetectPropertyType.BOOLEAN, "true"),

    @HelpGroup(primary = GROUP_NPM)
    @HelpDescription("The path of the node executable that is used by Npm")
    DETECT_NPM_NODE_PATH("detect.npm.node.path", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_PEAR)
    @HelpDescription("The path of the pear executable")
    DETECT_PEAR_PATH("detect.pear.path", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_PEAR)
    @HelpDescription("Set to true if you would like to include only required packages")
    DETECT_PEAR_ONLY_REQUIRED_DEPS("detect.pear.only.required.deps", DetectPropertyType.BOOLEAN, "false"),

    @HelpGroup(primary = GROUP_PIP)
    @HelpDescription("The path of the requirements.txt file")
    DETECT_PIP_REQUIREMENTS_PATH("detect.pip.requirements.path", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_GO)
    @HelpDescription("Path of the Go Dep executable")
    DETECT_GO_DEP_PATH("detect.go.dep.path", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_GO)
    @HelpDescription("If set to true, we will attempt to run 'init' and 'ensure' which can modify your development environment.")
    DETECT_GO_RUN_DEP_INIT("detect.go.run.dep.init", DetectPropertyType.BOOLEAN, "false"),

    @HelpGroup(primary = GROUP_DOCKER)
    @HelpDescription("Path of the docker executable")
    DETECT_DOCKER_PATH("detect.docker.path", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_DOCKER)
    @HelpDescription("If set to false, detect will attempt to run docker even if it cannot find a docker path.")
    DETECT_DOCKER_PATH_REQUIRED("detect.docker.path.required", DetectPropertyType.BOOLEAN, "true"),

    @HelpGroup(primary = GROUP_DOCKER)
    @HelpDescription("This is used to override using the hosted script by github url. You can provide your own script at this path.")
    DETECT_DOCKER_INSPECTOR_PATH("detect.docker.inspector.path", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_DOCKER)
    @HelpDescription("Version of the Hub Docker Inspector to use")
    DETECT_DOCKER_INSPECTOR_VERSION("detect.docker.inspector.version", DetectPropertyType.STRING, "latest"),

    @HelpGroup(primary = GROUP_DOCKER)
    @HelpDescription("A saved docker image - must be a .tar file. For detect to run docker either this property or detect.docker.image must be set.")
    DETECT_DOCKER_TAR("detect.docker.tar", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_DOCKER)
    @HelpDescription("The docker image name to inspect. For detect to run docker either this property or detect.docker.tar must be set.")
    DETECT_DOCKER_IMAGE("detect.docker.image", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_PATHS)
    @HelpDescription("Path of the bash executable")
    DETECT_BASH_PATH("detect.bash.path", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_LOGGING, additional = { GROUP_LOGGING, SEARCH_GROUP_DEBUG })
    @HelpDescription("The logging level of Detect")
    @AcceptableValues(value = { "ALL", "TRACE", "DEBUG", "INFO", "WARN", "ERROR", "FATAL", "OFF" }, caseSensitive = false, strict = true)
    LOGGING_LEVEL_COM_BLACKDUCKSOFTWARE_INTEGRATION("logging.level.com.blackducksoftware.integration", DetectPropertyType.STRING, "INFO"),

    @HelpGroup(primary = GROUP_SIGNATURE_SCANNER, additional = { SEARCH_GROUP_SIGNATURE_SCANNER, SEARCH_GROUP_HUB })
    @HelpDescription("If set to true, the signature scanner results will not be uploaded to the Hub and the scanner results will be written to disk.")
    DETECT_HUB_SIGNATURE_SCANNER_DRY_RUN("detect.hub.signature.scanner.dry.run", DetectPropertyType.BOOLEAN, "false"),

    @HelpGroup(primary = GROUP_SIGNATURE_SCANNER, additional = { SEARCH_GROUP_SIGNATURE_SCANNER, SEARCH_GROUP_HUB })
    @HelpDescription("If set to true, the signature scanner will, if supported by your Hub version, run in snippet scanning mode.")
    DETECT_HUB_SIGNATURE_SCANNER_SNIPPET_MODE("detect.hub.signature.scanner.snippet.mode", DetectPropertyType.BOOLEAN, "false"),

    @HelpGroup(primary = GROUP_SIGNATURE_SCANNER, additional = { SEARCH_GROUP_SIGNATURE_SCANNER, SEARCH_GROUP_HUB })
    @HelpDescription("Enables you to specify sub-directories to exclude from scans")
    DETECT_HUB_SIGNATURE_SCANNER_EXCLUSION_PATTERNS("detect.hub.signature.scanner.exclusion.patterns", DetectPropertyType.STRING_ARRAY),

    @HelpGroup(primary = GROUP_SIGNATURE_SCANNER, additional = { SEARCH_GROUP_SIGNATURE_SCANNER, SEARCH_GROUP_HUB })
    @HelpDescription("These paths and only these paths will be scanned.")
    DETECT_HUB_SIGNATURE_SCANNER_PATHS("detect.hub.signature.scanner.paths", DetectPropertyType.STRING_ARRAY),

    @HelpGroup(primary = GROUP_SIGNATURE_SCANNER, additional = { SEARCH_GROUP_SIGNATURE_SCANNER, SEARCH_GROUP_HUB })
    @HelpDescription("Comma separated list of file name patterns to exclude from the signature scan.")
    @HelpDetailed("Detect will recursively search within the scan targets for files/directories that match these file name patterns and will create the corresponding exclusion patterns for the signature scanner.\r\nThese patterns will be added to the patterns provided by detect.hub.signature.scanner.exclusion.patterns")
    DETECT_HUB_SIGNATURE_SCANNER_EXCLUSION_NAME_PATTERNS("detect.hub.signature.scanner.exclusion.name.patterns", DetectPropertyType.STRING_ARRAY, "node_modules"),

    @HelpGroup(primary = GROUP_SIGNATURE_SCANNER, additional = { SEARCH_GROUP_SIGNATURE_SCANNER, SEARCH_GROUP_HUB })
    @HelpDescription("The memory for the scanner to use.")
    DETECT_HUB_SIGNATURE_SCANNER_MEMORY("detect.hub.signature.scanner.memory", DetectPropertyType.INTEGER, "4096"),

    @HelpGroup(primary = GROUP_SIGNATURE_SCANNER, additional = { SEARCH_GROUP_SIGNATURE_SCANNER, SEARCH_GROUP_DEBUG, SEARCH_GROUP_HUB })
    @HelpDescription("Set to true to disable the Hub Signature Scanner.")
    DETECT_HUB_SIGNATURE_SCANNER_DISABLED("detect.hub.signature.scanner.disabled", DetectPropertyType.BOOLEAN, "false"),

    @HelpGroup(primary = GROUP_SIGNATURE_SCANNER, additional = { SEARCH_GROUP_SIGNATURE_SCANNER, SEARCH_GROUP_OFFLINE, SEARCH_GROUP_HUB })
    @HelpDescription("To use a local signature scanner, set its location with this property. This will be the path where the signature scanner was unzipped. This will likely look similar to /some/path/scan.cli-x.y.z")
    DETECT_HUB_SIGNATURE_SCANNER_OFFLINE_LOCAL_PATH("detect.hub.signature.scanner.offline.local.path", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_SIGNATURE_SCANNER, additional = { SEARCH_GROUP_SIGNATURE_SCANNER, SEARCH_GROUP_HUB })
    @HelpDescription("If this url is set, an attempt will be made to use it to download the signature scanner. The server url provided must respect the Hub's urls for different operating systems.")
    DETECT_HUB_SIGNATURE_SCANNER_HOST_URL("detect.hub.signature.scanner.host.url", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_SIGNATURE_SCANNER, additional = { SEARCH_GROUP_SIGNATURE_SCANNER, SEARCH_GROUP_HUB })
    @HelpDescription("The number of scans to run in parallel, defaults to 1, but if you specify -1, the number of processors on the machine will be used.")
    DETECT_HUB_SIGNATURE_SCANNER_PARALLEL_PROCESSORS("detect.hub.signature.scanner.parallel.processors", DetectPropertyType.INTEGER, "1"),

    @HelpGroup(primary = GROUP_SIGNATURE_SCANNER, additional = { SEARCH_GROUP_SIGNATURE_SCANNER, SEARCH_GROUP_HUB })
    @HelpDescription("Additional arguments to use when running the Hub signature scanner.")
    DETECT_HUB_SIGNATURE_SCANNER_ARGUMENTS("detect.hub.signature.scanner.arguments", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_PACKAGIST)
    @HelpDescription("Set this value to false if you would like to exclude your dev requires dependencies when ran")
    DETECT_PACKAGIST_INCLUDE_DEV_DEPENDENCIES("detect.packagist.include.dev.dependencies", DetectPropertyType.BOOLEAN, "true"),

    @HelpGroup(primary = GROUP_CPAN)
    @HelpDescription("The path of the perl executable")
    DETECT_PERL_PATH("detect.perl.path", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_CPAN)
    @HelpDescription("The path of the cpan executable")
    DETECT_CPAN_PATH("detect.cpan.path", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_CPAN)
    @HelpDescription("The path of the cpanm executable")
    DETECT_CPANM_PATH("detect.cpanm.path", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_SBT)
    @HelpDescription("The names of the sbt configurations to exclude")
    DETECT_SBT_EXCLUDED_CONFIGURATIONS("detect.sbt.excluded.configurations", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_SBT)
    @HelpDescription("The names of the sbt configurations to include")
    DETECT_SBT_INCLUDED_CONFIGURATIONS("detect.sbt.included.configurations", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_PROJECT_INFO, additional = { SEARCH_GROUP_PROJECT })
    @HelpDescription("The scheme to use when the package managers can not determine a version, either 'text' or 'timestamp'")
    DETECT_DEFAULT_PROJECT_VERSION_SCHEME("detect.default.project.version.scheme", DetectPropertyType.STRING, "text"),

    @HelpGroup(primary = GROUP_PROJECT_INFO, additional = { SEARCH_GROUP_PROJECT })
    @HelpDescription("The text to use as the default project version")
    DETECT_DEFAULT_PROJECT_VERSION_TEXT("detect.default.project.version.text", DetectPropertyType.STRING, "Default Detect Version"),

    @HelpGroup(primary = GROUP_PROJECT_INFO, additional = { SEARCH_GROUP_PROJECT })
    @HelpDescription("The timestamp format to use as the default project version")
    DETECT_DEFAULT_PROJECT_VERSION_TIMEFORMAT("detect.default.project.version.timeformat", DetectPropertyType.STRING, "yyyy-MM-dd\\'T\\'HH:mm:ss.SSS"),

    @HelpGroup(primary = GROUP_PROJECT_INFO, additional = { SEARCH_GROUP_PROJECT })
    @HelpDescription("If set, this will aggregate all the BOMs to create a single BDIO file with the name provided.")
    DETECT_BOM_AGGREGATE_NAME("detect.bom.aggregate.name", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_PROJECT_INFO, additional = { SEARCH_GROUP_PROJECT })
    @HelpDescription("When set to true, a Black Duck risk report in PDF form will be created")
    DETECT_RISK_REPORT_PDF("detect.risk.report.pdf", DetectPropertyType.BOOLEAN, "false"),

    @HelpGroup(primary = GROUP_PROJECT_INFO, additional = { SEARCH_GROUP_PROJECT })
    @HelpDescription("The output directory for risk report in PDF. Default is the source directory")
    DETECT_RISK_REPORT_PDF_PATH("detect.risk.report.pdf.path", DetectPropertyType.STRING, "."),

    @HelpGroup(primary = GROUP_PROJECT_INFO, additional = { SEARCH_GROUP_PROJECT })
    @HelpDescription("When set to true, a Black Duck notices report in text form will be created in your source directory")
    DETECT_NOTICES_REPORT("detect.notices.report", DetectPropertyType.BOOLEAN, "false"),

    @HelpGroup(primary = GROUP_PROJECT_INFO, additional = { SEARCH_GROUP_PROJECT })
    @HelpDescription("The output directory for notices report. Default is the source directory")
    DETECT_NOTICES_REPORT_PATH("detect.notices.report.path", DetectPropertyType.STRING, "."),

    @HelpGroup(primary = GROUP_CONDA)
    @HelpDescription("The path of the conda executable")
    DETECT_CONDA_PATH("detect.conda.path", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_CONDA)
    @HelpDescription("The name of the anaconda environment used by your project")
    DETECT_CONDA_ENVIRONMENT_NAME("detect.conda.environment.name", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_DOCKER)
    @HelpDescription("The path to the directory containing the docker inspector script, jar, and images")
    DETECT_DOCKER_INSPECTOR_AIR_GAP_PATH("detect.docker.inspector.air.gap.path", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_GRADLE)
    @HelpDescription("The path to the directory containing the air gap dependencies for the gradle inspector")
    DETECT_GRADLE_INSPECTOR_AIR_GAP_PATH("detect.gradle.inspector.air.gap.path", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_NUGET)
    @HelpDescription("The path to the directory containing the nuget inspector nupkg")
    DETECT_NUGET_INSPECTOR_AIR_GAP_PATH("detect.nuget.inspector.air.gap.path", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_NUGET)
    @HelpDescription("The source for nuget packages")
    DETECT_NUGET_PACKAGES_REPO_URL("detect.nuget.packages.repo.url", DetectPropertyType.STRING_ARRAY, "https://www.nuget.org/api/v2/"),

    @HelpGroup(primary = GROUP_GRADLE)
    @HelpDescription("The respository gradle should use to look for the gradle inspector")
    DETECT_GRADLE_INSPECTOR_REPOSITORY_URL("detect.gradle.inspector.repository.url", DetectPropertyType.STRING),

    @HelpGroup(primary = GROUP_HEX)
    @HelpDescription("The path of the rebar3 executable")
    DETECT_HEX_REBAR3_PATH("detect.hex.rebar3.path", DetectPropertyType.STRING),

    @HelpDescription("The path of the Yarn executable")
    @HelpGroup(primary = GROUP_YARN)
    DETECT_YARN_PATH("detect.yarn.path", DetectPropertyType.STRING),

    @HelpDescription("Set this to true to only scan production dependencies")
    @HelpGroup(primary = GROUP_YARN)
    DETECT_YARN_PROD_ONLY("detect.yarn.prod.only", DetectPropertyType.BOOLEAN, "false");

    // stop insert

    private final String propertyName;
    private final DetectPropertyType propertyType;
    private final String defaultValue;

    DetectProperty(final String propertyName, DetectPropertyType propertyType) {
        this.propertyName = propertyName;
        this.propertyType = propertyType;
        this.defaultValue = null;
    }

    DetectProperty(final String propertyName, DetectPropertyType propertyType, String defaultValue) {
        this.propertyName = propertyName;
        this.propertyType = propertyType;
        this.defaultValue = defaultValue;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public DetectPropertyType getPropertyType() {
        return propertyType;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public Boolean isEqualToDefault(String value) {
        String defaultValue = "";
        if (null != getDefaultValue()) {
            defaultValue = getDefaultValue();
        }
        return value.equals(defaultValue);
    }

    public final class PropertyConstants {
        public static final String GROUP_HUB_CONFIGURATION = "hub configuration";
        public static final String GROUP_GENERAL = "general";
        public static final String GROUP_LOGGING = "logging";
        public static final String GROUP_CLEANUP = "cleanup";
        public static final String GROUP_PATHS = "paths";
        public static final String GROUP_BOMTOOL = "bomtool";
        public static final String GROUP_CODELOCATION = "codelocation";
        public static final String GROUP_CONDA = "conda";
        public static final String GROUP_CPAN = "cpan";
        public static final String GROUP_DOCKER = "docker";
        public static final String GROUP_GO = "go";
        public static final String GROUP_GRADLE = "gradle";
        public static final String GROUP_HEX = "hex";
        public static final String GROUP_MAVEN = "maven";
        public static final String GROUP_NPM = "npm";
        public static final String GROUP_NUGET = "nuget";
        public static final String GROUP_PACKAGIST = "packagist";
        public static final String GROUP_PEAR = "pear";
        public static final String GROUP_PIP = "pip";
        public static final String GROUP_POLICY_CHECK = "policy check";
        public static final String GROUP_PROJECT_INFO = "project info";
        public static final String GROUP_PYTHON = "python";
        public static final String GROUP_SBT = "sbt";
        public static final String GROUP_SIGNATURE_SCANNER = "signature scanner";
        public static final String GROUP_YARN = "yarn";

        public static final String SEARCH_GROUP_SIGNATURE_SCANNER = "scanner";
        public static final String SEARCH_GROUP_POLICY = "policy";
        public static final String SEARCH_GROUP_HUB = "hub";
        public static final String SEARCH_GROUP_PROXY = "proxy";
        public static final String SEARCH_GROUP_OFFLINE = "offline";
        public static final String SEARCH_GROUP_PROJECT = "project";
        public static final String SEARCH_GROUP_DEBUG = "debug";
        public static final String SEARCH_GROUP_SEARCH = "search";

        public static final String PRINT_GROUP_DEFAULT = SEARCH_GROUP_HUB;

    }
}
