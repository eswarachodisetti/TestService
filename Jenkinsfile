pipeline {
  options {
    disableConcurrentBuilds()
  }
  agent {
    label "jenkins-maven"
  }
  environment {
    DEPLOY_NAMESPACE = "default"
  }
  stages {
     stage('Build') {
      steps {
        container('maven') {
         dir('TestService') {
		 checkout scm
		 sh 'mvn -version'
		 sh 'ls -lart'
		 sh 'mvn clean install'
			}
        }

      }
    }
    
   
  }
}
