export interface Department {
    id: string;
    name: string;
    description: string;
}

export interface Employee {
    id?: string;
    name: string;
    salary: string;
    address: string;
    phone: string;
    email: string;
    designation: string;
    department?: Department;
}
