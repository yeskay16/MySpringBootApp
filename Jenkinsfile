//Jenkin Pipeline code
@Library('jenkins-shared-libraries@master') _
node {
stage('Checkout SCM') {
checkout scm
}
// Wrap with the withCredentials
withCredentials(pipelineVariables.call()) {
//withCredentials([[dockerUserName: 'pkuma343'], [dockerPassword: 'Ponkmonk_138202']]) {
stage('Maven Tests') {
try {
bat 'mvn clean test'; junit '**/surefire-reports/*Test.xml'
} catch(err) {
junit '**/surefire-reports/*Test.xml'//; if(currentBuild.result == 'UNSTABLE') { currentBuild.result = 'FAILURE' }; throw err
}
}
stage('Sonar Scan') {
//bat 'mvn sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.branch.name=env.BRANCH_NAME'
bat 'mvn sonar:sonar -Dsonar.host.url=http://localhost:9000'
}
//stage('Junit step') {
//junit '**/surefire-reports/*Test.xml'
//}
if (!env.CHANGE_TARGET) {
stage('Maven Install') {
bat 'mvn clean install -Dmaven.test.skip=true'
}
stage('Docker build') {
bat 'docker build -t pkuma343/myimage:v1 -f Dockerfile .'
}
stage('Push Image') {
//bat 'docker login -u "pkuma343" -p "Ponkmonk_138202"'
//bat 'docker login -u vars.dockerUserName -p vars.dockerPassword'
bat "docker login -u ${dockerUserName} -p ${dockerPassword}"
bat 'docker push pkuma343/myimage:v1'
}
stage('Openshift Deploy') {
//bat '"C:\\Softwares\\openshift-origin-client-tools-v1.5.1-7b451fc-windows\\oc.exe" login --token=p-pw_rEzFszNt__4gKxJ5pjFmoiamnWj14OqUzb71g4 --server=https://api.us-west-1.starter.openshift-online.com:6443'
bat "C:\\Softwares\\openshift-origin-client-tools-v1.5.1-7b451fc-windows\\oc.exe login --token=${ocToken} --server=https://api.us-west-1.starter.openshift-online.com:6443"
bat '"C:\\Softwares\\openshift-origin-client-tools-v1.5.1-7b451fc-windows\\oc.exe" project my-project-pankaj'
bat '"C:\\Softwares\\openshift-origin-client-tools-v1.5.1-7b451fc-windows\\oc.exe" new-app -f api.yaml'
}
}
}
}