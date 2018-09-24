#!/bin/bash
cd /home/ubuntu/apache-jmeter-3.1/extras/PerformanceTesting/
cp -rf Reports ConsolidatedReports/Reports$(date +%F-%H:%M)
rm -rf Reports/
rm PerformanceTestLogFile.jtl
cd ~
apache-jmeter-3.1/bin/./jmeter -n -t apache-jmeter-3.1/extras/PerformanceTesting/JUNOPerformanceTestSuite.jmx -JUSERS=1 -JDURATION=30 -l apache-jmeter-3.1/extras/PerformanceTesting/PerformanceTestLogFile.jtl -e -o apache-jmeter-3.1/extras/PerformanceTesting/Reports