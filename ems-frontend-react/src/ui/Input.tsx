import { FC } from 'react';

const Input: FC<{
    value?: string;
    setValue?: (e: HTMLInputElement) => void;
    name?: string;
    type: string;
    placeholder?: string;
    description?: string;
    disabled?: boolean;
}> = (props) => {
    return (
        <div className={'flex flex-col gap-1'}>
            <label className={'text-sm text-gray-600 ml-1'}>{props.description}</label>
            <input
                type={props.type}
                name={props.name}
                value={props.value}
                onChange={(e) => props.setValue && props.setValue(e.target)}
                placeholder={props.placeholder}
                disabled={props.disabled}
                className={
                    'p-2 border-2 rounded hover:bg-gray-200 bg-gray-100 focus:border-sky-500 text-gray-600 outline-none transition-all ease-out duration-300 disabled:bg-gray-300 disabled:border-gray-300 disabled:text-gray-500'
                }
            />
        </div>
    );
};

export default Input;
