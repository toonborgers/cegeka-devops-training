stage name:'bla'
node {
    git 'https://github.com/toonborgers/cegeka-devops-training'
    sh 'dev/gradlew clean test'
}