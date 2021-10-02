node(){
    
    def template = load("${env.WORKSPACE}/scripts/template.groovy")
    
    currentBuild.result = "SUCCESS"
    
    try{
        stage('checkout'){
            checout scm
        }
         stage ('Development') {
             steps {
                script {template()}
              }
                }
         stage ('Staging') {
             steps {
                script {template()}
                    }
                }
         stage ('Production') {
             steps {
                script {template()}
                    }
        
    }
        catch (err){
            currentBuild.result = "FALURE"
            throw err
        }
}
