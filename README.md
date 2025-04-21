## Overview
- Test Automation Project for ecommerce lambdatest website with Selenium written by Java and based on Maven
- Using My Own Test Automation Engine as Testing Framework, Check Engine Details https://github.com/YehiaMetwally95/YehiaEngine
- Using TestNG as the Testing Framework
- Used Design Patterns:
  - Using Fluent Page Object Model Design Pattern in writing UI Test script and Page actions, thus chaining the Scenario steps and validations in one line of code
  - Using Cucumber as BDD Framework
  - Using Scenario Outline with Examples as Test Data Management

- Generating Very Detailed Allure Reports with All Scenario Steps And Screenshots for Passed/Hard-Assertion-Failed/Soft-Assertion-Failed Tests and for API Requests and Responses
- Perform Test Execution On Local / Headless / Remotely using Selenium Grid with Docker Containers
- Performing Parallel Execution from CI/CD Pipeline with GitHub Actions, Supplied by Selenium Grid with Docker, To Run Parallel Tests at same time, thus Reducing Execution time

## Application Under Test
- Website --> https://ecommerce-playground.lambdatest.io/index.php/

## Features
#### Structure of "test folder"
- Using Base Test Class for defining Annotations to Open and Close App, such that all Test Classes inherit from it
- Start each Test from a clean state by Setting and Tearing down App for Every Test Case
- "Using Assertions as follows:
    - All Assertions are implemented in Page Class (UI Tests) to allow the Fluency of Scenarios Steps with Validations like (Navigate.Writesteps..SoftAssertions.HardAssertions)
    - Using Hard assertions & Soft assertions for doing verifications within the test

#### Test Data Management
- Reading Global Variables and Configurations from Properties file, like selecting browser type, execution type, setting capabilities of every browser like headless execution , Set Parallel Modes
- Test Data Execution by reading test data from Scenario Outline and Examples of Feature File

#### Create CI/CD Pipeline with GitHub Actions
- Workflow that run UI Tests Remotely In Parallel Across Different Browsers
  - Check Generated Allure Report from this link https://drive.google.com/drive/folders/1KwyhXrG2xfzMjKNorVfsbP09StW9YFAE?usp=sharing
- Workflow that run UI Tests Remotely In Sequence
  - Check Generated Allure Report from this link https://drive.google.com/drive/folders/1RCo5vVTUmT1RWQRcMVnQ_vyltfZlKgTs?usp=sharing
- Run Workflows on Different Triggers: after every Push, after every Pull Request and Manually
- Generate the Allure Reports after every Workflow run such that
    - Separate Reports for Tests related to a Single Job
    - Combined Report that Include All Tests that runs on all Jobs

## Installation
##### 1- Download Allure Report from here https://github.com/allure-framework/allure2/releases
##### 2- Download Docker from here https://docs.docker.com/desktop/setup/install/windows-install/
##### 3- Download Apache Maven from here https://maven.apache.org/download.cgi
##### 4- Add All bin Directories of Allure , Docker & Maven in Environmental Variables like the below screen ! ![img.png](img.png)
##### 5- Docker Must be Run on your machine
##### 6 To Setup Selenium Grid with Docker Container in order to Run Tests Remotely, Just run the following command in Intellij Terminal
```bash
docker compose -f src/main/resources/dockerFiles/docker-compose-grid-v3.yml up --scale chrome=0 --scale edge=2 --scale firefox=0 -d 
```
##### 7- After The Setup, To be Able to Run Remotely, The flags "executionType" in Configuration.properties shall be set with "Remote"
##### 8- After Finish the Test Execution, Its Better to CleanUp and Stop running the Docker Containers by running the following command in Terminal
```bash
docker compose -f src/main/resources/dockerFiles/docker-compose-grid-v3.yml down
```  