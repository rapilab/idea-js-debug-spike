# idea-js-debug-spike

IDEA JavaScript Language

 - ActionScript
 - EcmaScript6
 - Flow
 - JavaScript
    - babel
    - bower
    - ecmascript
    - nashorn
    - frameworks
       - amd
       - backbone
       - react
       - systemjs
       - webpack
       - extjs
       - dojo
 - TypeScript

Connector:

 - ChromeConnector.jar
 - debugConnector.js
 - FirefoxConnector.jar
 - JavaEEJavaScriptDebug.jar
 - javascript-debugger-featuresTrainer.jar
 - JavaScriptDebugger.jar
 - nashorn-debugger.jar
 - nashorn-debugger-9-rt.jar
 - nashorn-debugger-rt.jar

Workflow:

Mocha

 - MochaUtil
 - MochaRunSettings
 - MochaRunProgramRunner
 - MochaRunProfileState.executeSync -> MochaRunProfileState.configureCommandLine
     - NodeCommandLineUtil.createCommandLineForTestTools -> NodeCommandLineUtil.createCommandLine
     - configureUsefulEnvironment
     - prependNodeDirToPATH
         - NodeJsLocalInterpreter