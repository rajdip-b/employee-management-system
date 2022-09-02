import { FC, ReactNode } from 'react';

const Button: FC<{ onClick: () => void; children: ReactNode; className?: string; disabled?: boolean }> = (props) => {
    return (
        <button
            disabled={props.disabled}
            onClick={props.onClick}
            className={`p-3 bg-sky-500 text-gray-50 hover:bg-sky-600 transition-all ease-out duration-300 disabled:bg-gray-500 disabled:cursor-not-allowed ${props.className}`}
        >
            {props.children}
        </button>
    );
};

export default Button;
