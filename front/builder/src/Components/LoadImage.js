import React, {useEffect, useState} from 'react';

function LoadImage(props) {
    const [image, setImage] = useState();

    useEffect(() => {
        console.log(props.imageId)
        const apiImage = 'http://localhost:8080/api/v1/public/image/' + props.imageId;
        fetch(apiImage)
            .then(res => res.blob())
            .then(blob => {
                const reader = new FileReader();
                reader.readAsDataURL(blob);
                reader.onloadend = () => setImage(reader.result)
            });
    }, []);
    return (
        <img src={image} alt="No image" height="100" width="150"></img>
    );
}

export default LoadImage;