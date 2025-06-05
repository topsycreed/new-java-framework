pipeline {
  agent any

  tools {
    gradle 'Gradle 8.5'
  }

  environment {
    SELENIUM_GRID_URL = 'http://selenium-hub:4444/wd/hub'
  }

  stages {
    stage('Checkout') {
      steps {
        git branch: '12-jenkins', url: 'https://github.com/topsycreed/new-java-framework.git'
      }
    }

    stage('Build & Test') {
      environment {
        LOGIN = credentials('login')
        PASSWORD = credentials('password')
      }
      steps {
        sh 'gradle clean test -Denv=$env -Dlogin=$LOGIN -Dpassword=$PASSWORD -Dselenium.remote.url=$SELENIUM_GRID_URL'
      }
    }
  }

  post {
    always {
      junit '**/build/test-results/test/TEST-*.xml'
      allure([
              includeProperties: false,
              jdk              : '',
              results          : [[path: 'build/allure-results']]
      ])
    }
  }
}