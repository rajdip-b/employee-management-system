import { FC, useCallback, useEffect, useState } from 'react';
import { Department, Employee } from '../../util/types';
import ActionButton from '../../ui/ActionButton';
import AddEmployeeModal from './AddEmployeeModal';
import useHttp from '../../hooks/useHttp';

const Dashboard: FC<{ selectedItem: Department | null }> = (props) => {
    const [employees, setEmployees] = useState<Employee[]>([]);
    const [addEmployeeModalOpen, setAddEmployeeModalOpen] = useState(false);
    const makeRequest = useHttp();

    useEffect(() => {
        props.selectedItem &&
            makeRequest(
                {
                    url: `${process.env.REACT_APP_API_URL}/department/${props.selectedItem.id}/employees`,
                },
                (data) => console.log(data)
            );
    }, [props.selectedItem]);

    const toggleModal = useCallback(() => setAddEmployeeModalOpen(!addEmployeeModalOpen), [addEmployeeModalOpen]);

    return (
        <div className={'py-5 px-10 w-full'}>
            {addEmployeeModalOpen && <AddEmployeeModal onClose={toggleModal} department={props.selectedItem!} />}
            {props.selectedItem !== null ? (
                <div className={'flex flex-col gap-5 text-gray-500 pb-2 border-b'}>
                    <div className={'text-slate-700 text-2xl font-bold'}>{props.selectedItem.name}</div>
                    <div className={'text-slate-500 text-lg'}>{props.selectedItem.description}</div>
                    <div className={'text-slate-700 font-bold'}>Employees</div>
                    <div className={''}>
                        <div className={'grid grid-cols-10 text-sm'}>
                            <span className={'col-span-1'}>Id</span>
                            <span className={'col-span-4'}>Name</span>
                            <span className={'col-span-2'}>Phone</span>
                            <span className={'col-span-2'}>Salary</span>
                            <span className={'col-span-1'}>View</span>
                        </div>
                    </div>
                    <ActionButton onClick={toggleModal} />
                </div>
            ) : (
                <div className={'text-2xl font-light text-gray-500'}>Select a department to view its employees.</div>
            )}
        </div>
    );
};

export default Dashboard;
