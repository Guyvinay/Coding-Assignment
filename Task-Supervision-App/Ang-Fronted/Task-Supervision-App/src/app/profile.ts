export interface Profile {

}
export interface LoginCreds {
    username:'',
    password:''
}

export interface RegisterProfile {
    name:'',
    email:'',
    password:'',
    profile_picture:'',
}

export interface LoggedInProfile {
    name:'',
    email:'',
    password:'',
    profile_picture:'',
    token:'',
}
