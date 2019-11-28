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
		 sh 'cd TestService && ls -lart && mvn clean install'
		 sleep 120
			}
        }

      }
    }
    
   
  }
}
