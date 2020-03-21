node {
stage('Checkout SCM') {
checkout scm
}
stage('Maven Install') {
bat 'mvn clean install'
}
stage('Docker build') {
bat 'dokcer build -t myimage:v1 -f Dockerfile'
}
}