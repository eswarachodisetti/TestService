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
		 sh 'export GOOGLE_APPLICATION_CREDENTIALS=/home/jenkins/.gcp/.dockerconfigjson'
		 sh 'cd /home/jenkins/ && ls -lart'
		 sh 'cd TestService && ls -lart && mvn clean deploy'
		 sleep 300
			}
        }

      }
    }
    
   
  }
}
