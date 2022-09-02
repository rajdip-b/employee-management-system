import { FC, ReactNode } from 'react';

const ModalOverlay: FC<{ className?: string; children: ReactNode }> = (props) => {
    return (
        <div
            className={
                'w-screen h-screen absolute left-0 top-0 bg-gray-700/50 z-30 flex items-center justify-center ' +
                props.className
            }
        >
            {props.children}
        </div>
    );
};

export default ModalOverlay;
