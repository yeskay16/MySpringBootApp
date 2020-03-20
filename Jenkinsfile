node {
stage('Checkout SCM') {
checkout scm
}
stage('Maven Install') {
bat 'mvn clean install'
}
}