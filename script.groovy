def buildJar(){
  echo 'building the application...'
  sh 'mvn package'
}

def buildImage(){
  echo 'building the docker image...'
  withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passowrdVariable: 'PASS', usernameVariable: 'USER')]){
      sh 'docker build -t syukay/demo-app:jma-2.3 .'
      sh 'echo $PASS | docker login -u $USER --password-stdin'
      sh 'docker push syukay/demo-app:jma-2.3'
  }
}

def deployApp(){
  echo 'deploying the application...'
}

return this
