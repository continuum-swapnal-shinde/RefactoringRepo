$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("platform/LongRunningPlugin.feature");
formatter.feature({
  "line": 1,
  "name": "Long Running Plugin Scenarios",
  "description": "",
  "id": "long-running-plugin-scenarios",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Verify Agent Core is able update the config file of LRP-C2145807,C2145808",
  "description": "",
  "id": "long-running-plugin-scenarios;verify-agent-core-is-able-update-the-config-file-of-lrp-c2145807,c2145808",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@PlatformRegression777"
    },
    {
      "line": 3,
      "name": "@Win7_32Bit"
    },
    {
      "line": 3,
      "name": "@Win7_64Bit"
    },
    {
      "line": 3,
      "name": "@Win8_32Bit"
    },
    {
      "line": 3,
      "name": "@Win8_64Bit"
    },
    {
      "line": 3,
      "name": "@Win10_32Bit"
    },
    {
      "line": 3,
      "name": "@Win10_64Bit"
    },
    {
      "line": 3,
      "name": "@Win8.1_32Bit"
    },
    {
      "line": 3,
      "name": "@WinServer8_64Bit"
    },
    {
      "line": 3,
      "name": "@WinServer12_64Bit"
    },
    {
      "line": 3,
      "name": "@WinServer16_64Bit"
    },
    {
      "line": 3,
      "name": "@WinServer12R2_64Bit"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "SSH connection establishes with remote test machine from tag",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User fetch AgentCore EndPointID from agentCore config file from tag",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "User send a Post request for mailbox API LRP endpoint as \"\u003cEndPoint\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "User should validate the status code as \"200\"OK",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "User fetch and validate event log plugin json from tag \"\u003cLogLevel\u003e\"",
  "keyword": "And "
});
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": "long-running-plugin-scenarios;verify-agent-core-is-able-update-the-config-file-of-lrp-c2145807,c2145808;",
  "rows": [
    {
      "cells": [
        "RowIndex",
        "ServiceStatus",
        "EndPoint",
        "LogLevel"
      ],
      "line": 12,
      "id": "long-running-plugin-scenarios;verify-agent-core-is-able-update-the-config-file-of-lrp-c2145807,c2145808;;1"
    },
    {
      "cells": [
        "1",
        "RUNNING",
        "/agent/v1/EndPointID/execute",
        "DEBUG"
      ],
      "line": 13,
      "id": "long-running-plugin-scenarios;verify-agent-core-is-able-update-the-config-file-of-lrp-c2145807,c2145808;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 135707349,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Verify Agent Core is able update the config file of LRP-C2145807,C2145808",
  "description": "",
  "id": "long-running-plugin-scenarios;verify-agent-core-is-able-update-the-config-file-of-lrp-c2145807,c2145808;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@PlatformRegression777"
    },
    {
      "line": 3,
      "name": "@Win10_64Bit"
    },
    {
      "line": 3,
      "name": "@WinServer12_64Bit"
    },
    {
      "line": 3,
      "name": "@Win8.1_32Bit"
    },
    {
      "line": 3,
      "name": "@WinServer8_64Bit"
    },
    {
      "line": 3,
      "name": "@Win7_64Bit"
    },
    {
      "line": 3,
      "name": "@Win8_64Bit"
    },
    {
      "line": 3,
      "name": "@Win7_32Bit"
    },
    {
      "line": 3,
      "name": "@WinServer12R2_64Bit"
    },
    {
      "line": 3,
      "name": "@Win10_32Bit"
    },
    {
      "line": 3,
      "name": "@WinServer16_64Bit"
    },
    {
      "line": 3,
      "name": "@Win8_32Bit"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "SSH connection establishes with remote test machine from tag",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User fetch AgentCore EndPointID from agentCore config file from tag",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "User send a Post request for mailbox API LRP endpoint as \"/agent/v1/EndPointID/execute\"",
  "matchedColumns": [
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "User should validate the status code as \"200\"OK",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "User fetch and validate event log plugin json from tag \"DEBUG\"",
  "matchedColumns": [
    3
  ],
  "keyword": "And "
});
formatter.match({
  "location": "CommonSteps.sshConnectionEstablishedWithRemoteTestMachineFromTag()"
});
formatter.write("\u003cfont color\u003d\"blue\"\u003e\u003cb\u003eConnection Establish for : 10.2.114.113:22\u003c/b\u003e\u003c/font\u003e\u003cbr/\u003e");
formatter.result({
  "duration": 1298537162,
  "status": "passed"
});
formatter.match({
  "location": "CommonSteps.i_fetch_AgentCore_EndPointID_from_agentCore_config_file_from_tag()"
});
formatter.write("\u003cfont color\u003d\"blue\"\u003e\u003cb\u003eEndPoint ID is 69c21305-4a58-4433-a968-19120bb58afc\u003c/b\u003e\u003c/font\u003e\u003cbr/\u003e");
formatter.result({
  "duration": 489255984,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "/agent/v1/EndPointID/execute",
      "offset": 58
    }
  ],
  "location": "ScriptingPluginStep.i_send_a_Post_request_for_mailbox_API_LRP_endpoint_as(String)"
});
formatter.write("I send a Post request for URL https://integration.agent.exec.itsupport247.net/agent/v1/69c21305-4a58-4433-a968-19120bb58afc/execute");
formatter.write("Json format used for post :{\"path\":\"\\/eventlog\\/configuration\",\"name\":\"LRP config\",\"timestampUTC\":\"2017-01-11T12:24:53.489110938Z\",\"type\":\"CONFIGURATION\",\"message\":\"{\\n  \\\"pluginPath\\\": {\\n    \\\"shutdown\\\": \\\"\\/eventlog\\/shutdown\\\",\\n    \\\"reload\\\": \\\"\\/eventlog\\/config\\/refresh\\\"\\n  },\\n  \\\"agentPath\\\": {\\n    \\\"data\\\": \\\"\\/eventlog\\/data\\\"\\n  },\\n  \\\"logLevel\\\":\\\"DEBUG\\\",\\n  \\\"maxLogFileSizeInMB\\\":1,\\n  \\\"oldLogFileToKeep\\\":5,\\n  \\\"rules\\\": [\\n    {\\n      \\\"collector\\\": \\\"winlog\\\",\\n      \\\"description\\\": \\\"Error on Disk FileSystem Event\\\",\\n      \\\"eventDetails\\\": {\\n        \\\"facility\\\": 17,\\n        \\\"source\\\": \\\"Ntfs\\\",\\n        \\\"eventIDs\\\": [\\\"55\\\"],\\n          \\\"severity\\\": [3,4]\\n      },\\n      \\\"filters\\\": [{\\n        \\\"field\\\": \\\"description\\\",\\n        \\\"negativeMatch\\\": \\\"(?i).*\\\\\\\\b(?:Temp|HarddiskVolumeShadowCopy)\\\\\\\\b.*\\\"\\n      }]\\n    },\\n    {\\n      \\\"collector\\\": \\\"winlog\\\",\\n      \\\"description\\\": \\\"Required Machine Restart\\\",\\n      \\\"eventDetails\\\": {\\n        \\\"facility\\\": 18,\\n        \\\"source\\\": \\\"RestartManager\\\",\\n        \\\"eventIDs\\\": [\\\"10005\\\"],\\n        \\\"severity\\\": [4, 5]\\n      },\\n      \\\"filters\\\": [{\\n        \\\"field\\\": \\\"description\\\",\\n        \\\"positiveMatch\\\": \\\"(?i)Machine restart is required\\\"\\n      }]\\n    },\\n    {\\n      \\\"collector\\\": \\\"winlog\\\",\\n      \\\"description\\\": \\\"Required Machine Restart\\\",\\n      \\\"eventDetails\\\": {\\n        \\\"facility\\\": 17,\\n        \\\"source\\\": \\\"Microsoft-Windows-WindowsUpdateClient\\\",\\n        \\\"eventIDs\\\": [\\\"21\\\"],\\n        \\\"severity\\\": [4, 5]\\n      }\\n    },\\n    {\\n      \\\"collector\\\": \\\"winlog\\\",\\n      \\\"description\\\": \\\"6008: Unexpected reboot \\/ 6005: Event Log service was started\\\",\\n      \\\"eventDetails\\\": {\\n        \\\"facility\\\": 17,\\n        \\\"source\\\": \\\"EventLog\\\",\\n        \\\"eventIDs\\\": [\\\"6008\\\",\\\"6005\\\"],\\n        \\\"severity\\\": [3, 5],\\n        \\\"fetchTime\\\": \\\"5m\\\"\\n      }\\n    },\\n    {\\n      \\\"collector\\\": \\\"winlog\\\",\\n      \\\"description\\\": \\\"Unexpected reboot (Recovered from BSOD)\\\",\\n      \\\"eventDetails\\\": {\\n        \\\"facility\\\": 17,\\n        \\\"source\\\": \\\"Microsoft-Windows-WER-SystemErrorReporting\\\",\\n        \\\"eventIDs\\\": [\\\"1001\\\"],\\n        \\\"severity\\\": [3, 5],\\n        \\\"fetchTime\\\": \\\"5m\\\"\\n      }\\n    },\\n    {\\n      \\\"collector\\\": \\\"winlog\\\",\\n      \\\"description\\\": \\\"Corrupt file popup\\\",\\n      \\\"eventDetails\\\": {\\n        \\\"facility\\\": 17,\\n        \\\"source\\\": \\\"Application popup\\\",\\n        \\\"eventIDs\\\": [\\\"26\\\"],\\n        \\\"severity\\\": [3]\\n      },\\n      \\\"filters\\\": [{\\n        \\\"field\\\": \\\"description\\\",\\n        \\\"positiveMatch\\\": \\\"(?i)Corrupt File\\\"\\n      }]\\n\\n    },\\n    {\\n      \\\"collector\\\": \\\"winlog\\\",\\n      \\\"description\\\": \\\"\\\",\\n      \\\"eventDetails\\\": {\\n        \\\"facility\\\": 18,\\n        \\\"source\\\": \\\"Windows Backup\\\",\\n        \\\"eventIDs\\\": [\\\"4097\\\", \\\"4098\\\", \\\"4104\\\"],\\n        \\\"severity\\\": [3, 5]\\n      }\\n    },\\n    {\\n      \\\"collector\\\": \\\"winlog\\\",\\n      \\\"description\\\": \\\"\\\",\\n      \\\"eventDetails\\\": {\\n        \\\"facility\\\": 18,\\n        \\\"source\\\": \\\"Microsoft-Windows-Backup\\\",\\n        \\\"eventIDs\\\": [\\\"753\\\", \\\"754\\\", \\\"517\\\"],\\n        \\\"severity\\\": [3, 5]\\n      }\\n    },\\n    {\\n      \\\"collector\\\": \\\"syslog\\\",\\n      \\\"description\\\": \\\"Test event\\\",\\n      \\\"eventDetails\\\": {\\n        \\\"source\\\": \\\"systemd\\\",\\n        \\\"facility\\\": 1,\\n        \\\"severity\\\": [6,4],\\n        \\\"fetchTime\\\": \\\"5m\\\"\\n      },\\n      \\\"filters\\\": [{\\n        \\\"field\\\": \\\"description\\\",\\n        \\\"positiveMatch\\\": \\\"(?i).*Test.*\\\"\\n      },{\\n        \\\"field\\\": \\\"source\\\",\\n        \\\"negativeMatch\\\": \\\"(?i).*Test.*\\\"\\n      }]\\n    }\\n  ],\\n  \\\"rSyslogFilePath\\\": \\\"\\/var\\/log\\/agent.log\\\",\\n  \\\"flushInterval\\\": 0,\\n  \\\"timeCheck\\\": 1000,\\n  \\\"maxTime\\\": 5, \\n  \\\"shutdownTimeout\\\": \\\"1m\\\"\\n}\\n\",\"version\":\"2.0\"}");
formatter.result({
  "duration": 62017356632,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 41
    }
  ],
  "location": "CommonSteps.i_should_validate_the_status_code_as_OK(String)"
});
formatter.write("Status OK");
formatter.result({
  "duration": 440229974,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "DEBUG",
      "offset": 56
    }
  ],
  "location": "LongRunningPluginStep.i_fetch_and_validate_eventlog_plugin_json(String)"
});
