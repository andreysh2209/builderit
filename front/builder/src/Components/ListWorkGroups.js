import React, {useEffect, useState} from 'react';
import {Button, Card, Col, Container, Row} from "react-bootstrap";
import axios from "axios";
import {Link} from "react-router-dom";
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
        <Container style={{paddingTop: '2rem', paddingBottom: '2rem'}}>
            <Row>
                {workGroups.map((d) => (
                    <Col key={d.id}>
                        <Card style={{width: '18rem', height: '26rem', marginTop: '2px'}}>
                            <LoadImage imageId={d.imageId}/>
                            <Card.Body>
                                <Card.Title>{d.name}</Card.Title>
                                <Card.Text>{d.description}</Card.Text>
                                <Link> <Button
                                    variant='primary'>Details</Button> </Link>
                            </Card.Body>
                        </Card>
                    </Col>
                ))}
            </Row>
         </Container>
    );
}

export default ListWorkGroups;