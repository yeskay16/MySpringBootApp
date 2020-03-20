node {
stage('Checkout SCM') {
checkout scm
}
stage('Maven Install') {
sh 'mvn clean install'
}
}