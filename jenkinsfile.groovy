pipeline {
  agent any
  stages {
    stage('verify browsers') {
      steps {
        sh 'google-chrome --version'
        sh 'firefox --version'
      }
    }
    stage('Run Test') {
      steps {
        sh './mvnw clean test'
      }
    }
  }
}