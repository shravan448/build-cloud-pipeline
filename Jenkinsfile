pipeline {

  environment {
    ORG = 'shravan448'
    APP_NAME = 'my-first-boot-gke'
   
  }
  stages {
    stage('CI Build and push snapshot') {
     
      steps {
        container('maven') {
          sh "echo maven clean"
		  sh "mvn clean"
          sh "mvn package"
          sh "skaffold version"
          sh "export VERSION=$PREVIEW_VERSION && skaffold build -f skaffold.yaml"
          sh "jx step post build --image $DOCKER_REGISTRY/$ORG/$APP_NAME:$PREVIEW_VERSION"
          dir('charts/preview') {
            sh "make preview"
            sh "jx preview --app $APP_NAME --dir ../.."
          }
        }
      }
    }
    
   
  }
 
}
