export class Student {
    id: number;
    name: string;
    lastname: string;
    email: string;
    constructor(
        id: number = 0, 
        name: string = '', 
        latname: string = '', 
        email: string = '', 
    ) {
        this.id = id;
        this.name = name;
        this.lastname = latname;
        this.email =email;
    }
  }
  