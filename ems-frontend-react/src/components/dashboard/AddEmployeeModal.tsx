import { FC, useCallback, useState } from 'react';
import { Department, Employee } from '../../util/types';
import ModalOverlay from '../common/ModalOverlay';
import Input from '../../ui/Input';
import { CloseRounded } from '@mui/icons-material';
import Button from '../../ui/Button';
import useHttp from '../../hooks/useHttp';

const AddEmployeeModal: FC<{ department: Department; onClose: () => void }> = (props) => {
    const makeRequest = useHttp();
    const [loading, setLoading] = useState(false);
    const [employeeDetail, setEmployeeDetail] = useState<Employee>({
        name: '',
        phone: '',
        salary: '',
        address: '',
        email: '',
        designation: '',
        department: props.department,
    });

    const handleChange: (e: HTMLInputElement) => void = (e) => {
        setEmployeeDetail((prev) => ({ ...prev, [e.name]: e.value }));
    };

    const handleAddClick = useCallback(() => {
        makeRequest(
            {
                url: `${process.env.REACT_APP_API_URL}/employee/`,
                method: 'POST',
                body: employeeDetail,
            },
            (data) => console.log(data),
            (data) => console.log(data)
        );
    }, []);

    return (
        <ModalOverlay>
            <div className={'w-[500px] h-fit rounded-lg bg-gray-100 p-5 flex flex-col gap-5'}>
                <div className={'flex items-center justify-between'}>
                    <div className={'text-xl font-bold text-slate-700'}>Add an employee</div>
                    <button onClick={props.onClose} className={'text-rose-500'}>
                        <CloseRounded />
                    </button>
                </div>
                <Input value={props.department.name} type={'text'} disabled={true} description={'Department name'} />
                <Input
                    value={employeeDetail.name}
                    setValue={handleChange}
                    disabled={loading}
                    type={'text'}
                    name={'name'}
                    placeholder={'John Doe'}
                    description={'Name of employee'}
                />
                <Input
                    value={employeeDetail.email}
                    setValue={handleChange}
                    type={'text'}
                    name={'email'}
                    disabled={loading}
                    placeholder={'johndoe@gmail.com'}
                    description={'Email of employee'}
                />
                <Input
                    value={employeeDetail.phone}
                    setValue={handleChange}
                    type={'text'}
                    disabled={loading}
                    name={'phone'}
                    placeholder={'xxxxxxxxxx'}
                    description={'Phone of employee'}
                />
                <Input
                    value={employeeDetail.address}
                    setValue={handleChange}
                    type={'text'}
                    disabled={loading}
                    name={'address'}
                    placeholder={'30A Kings Lane'}
                    description={'Address of employee'}
                />
                <Input
                    value={employeeDetail.salary}
                    setValue={handleChange}
                    type={'text'}
                    disabled={loading}
                    name={'salary'}
                    placeholder={'30000'}
                    description={'Salary of employee (in USD)'}
                />
                <Input
                    value={employeeDetail.designation}
                    setValue={handleChange}
                    type={'text'}
                    disabled={loading}
                    name={'designation'}
                    placeholder={'Sr. Product manager'}
                    description={'Designation of employee'}
                />
                <Button disabled={loading} className={'w-full rounded'} onClick={handleAddClick}>
                    Add
                </Button>
            </div>
        </ModalOverlay>
    );
};

export default AddEmployeeModal;
