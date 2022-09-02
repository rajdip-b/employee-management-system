import { FC } from 'react';
import { Department } from '../../util/types';

const SidebarItem: FC<{
    department: Department;
    selectedItem: Department | null;
    onClick: (item: Department) => void;
}> = (props) => {
    return (
        <button
            onClick={() => props.onClick(props.department)}
            className={`flex items-start py-2 px-4 transition-all duration-300 w-full pl-5 border-l-transparent border-l-4
                ${
                    props.selectedItem && props.selectedItem.id === props.department.id
                        ? 'bg-sky-500 text-gray-50'
                        : 'hover:border-l-sky-500 text-gray-600 hover:border-l-sky-500 hover:bg-gray-200 hover:pl-10'
                }`}
        >
            <div className={'text-sm'}>{props.department.name}</div>
        </button>
    );
};

export default SidebarItem;
