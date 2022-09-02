import { useCallback } from 'react';
// @ts-ignore
import jQuery from 'jquery';

type request = {
    method?: string | null;
    body?: object | null;
    url: string;
};

type callback = (data?: any) => void;

const useHttp = () => {
    return useCallback(
        (requestOptions: request, successCallback?: callback, errorCallback?: callback, completeCallback?: callback) =>
            jQuery.ajax({
                url: requestOptions.url,
                method: requestOptions.method ? requestOptions.method : 'GET',
                data: requestOptions.body ? JSON.stringify(requestOptions.body) : {},
                contentType: 'application/json',
                success: (data: any) => {
                    Promise.resolve();
                    successCallback && successCallback(data);
                },
                error: (data: any) => {
                    Promise.reject();
                    errorCallback && errorCallback(data);
                },
                complete: () => {
                    completeCallback && completeCallback();
                },
            }),
        []
    );
};

export default useHttp;
