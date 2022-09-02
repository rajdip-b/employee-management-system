import React, { useCallback, useEffect } from 'react';
import Navbar from './components/navbar/Navbar';
import Sidebar from './components/sidebar/Sidebar';
import Dashboard from './components/dashboard/Dashboard';
import useHttp from './hooks/useHttp';
import { Department, Employee } from './util/types';

function App() {
    const [departments, setDepartments] = React.useState<Department[]>([]);
    const [employees, setEmployees] = React.useState<Employee[]>([]);
    const [selectedDepartment, setSelectedDepartment] = React.useState<Department | null>(null);
    const makeRequest = useHttp();

    const handleSelectedItemChange = useCallback((item: Department) => {
        setSelectedDepartment(item);
    }, []);

    useEffect(() => {
        makeRequest(
            {
                url: `${process.env.REACT_APP_API_URL}/department/`,
            },
            (data) => setDepartments(data)
        );
    }, []);

    return (
        <div className={'flex flex-col items-start'}>
            <Navbar />
            <div className={'flex w-full'}>
                <Sidebar
                    onChange={handleSelectedItemChange}
                    departments={departments}
                    selectedDepartment={selectedDepartment}
                />
                <Dashboard selectedItem={selectedDepartment} />
            </div>
        </div>
    );
}

export default App;
