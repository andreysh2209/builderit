import React, {useEffect, useState} from 'react';
import {Button, Card, Col, Row} from "react-bootstrap";
import axios from "axios";
import LoadImage from "./LoadImage";

function ListWorkGroups(props) {
    const [workGroups, setWorkGroups] = useState([]);
    useEffect(() => {
        const url = "http://localhost:8080/api/v1/public/workGroup"
        axios.get(url)
            .then(function (response) {
                setWorkGroups(response.data)
                console.log(response.data)
            })

            .catch(function (error) {
                alert("ERROR OUR")
            })
    }, [setWorkGroups]);
    return (
       // <Container>
            <Row>
                {
                    workGroups.map(item=>{
                       <Col key={item.id}>
                           <Card style={{ width: '18rem' }}>
                               <LoadImage imageId={item.imageId} />
                               <Card.Body>
                                   <Card.Title>{item.name}</Card.Title>
                                   <Card.Text>{item.description}</Card.Text>
                                   <Button variant="primary">Go somewhere</Button>
                               </Card.Body>
                           </Card>
                       </Col>
                    })
                }
            </Row>
        // </Container>
    );
}

export default ListWorkGroups;