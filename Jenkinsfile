node {
stage('Checkout SCM') {
checkout scm
}
stage('Maven Install') {
bat 'mvn clean install'
}
stage('Docker build') {
bat 'docker build -t pkuma343/myimage:v1 -f Dockerfile .'
}
stage('Push Image') {
bat 'docker login -u "pkuma343" -p "Ponkmonk_138202"'
bat 'docker push pkuma343/myimage:v1'
}
stage('Openshift Deploy') {
bat 'oc login --token=p-pw_rEzFszNt__4gKxJ5pjFmoiamnWj14OqUzb71g4 --server=https://api.us-west-1.starter.openshift-online.com:6443'
bat 'oc project my-project-pankaj'
bat 'oc create -f api.yaml'
}
}