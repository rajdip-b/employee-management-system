import { FC } from 'react';
import { Department } from '../../util/types';
import SidebarItem from './SidebarItem';

const Sidebar: FC<{
    departments: Department[];
    selectedDepartment: Department | null;
    onChange: (item: Department) => void;
}> = (props) => {
    return (
        <div className={'w-[300px] h-[92.5vh] bg-gray-100 flex flex-col gap-5 justify-between '}>
            <div className={'text-gray-600 text-lg p-5'}>Departments</div>
            <div className={'flex flex-col items-start w-full overflow-y-scroll flex-grow h-full'}>
                {props.departments.map((d) => (
                    <SidebarItem onClick={props.onChange} selectedItem={props.selectedDepartment} department={d} />
                ))}
            </div>
            <button className={'bg-slate-700 w-full p-5 text-gray-50'}>Add Department</button>
        </div>
    );
};

export default Sidebar;
