#!/usr/bin/env bash
mvn clean install -Dtest=TestRunner -Dcucumber.filter.tags="@smoke" -Dbrowser.option.headless=true && open target/index.html
