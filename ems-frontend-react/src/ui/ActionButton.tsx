import { FC } from 'react';
import { AddRounded } from '@mui/icons-material';
import Button from './Button';

const ActionButton: FC<{ onClick: () => void }> = ({ onClick }) => {
    return (
        <Button className={'rounded-full absolute right-5 bottom-5'} onClick={onClick}>
            <AddRounded />
        </Button>
    );
};

export default ActionButton;
