import React, {useState} from 'react';
import {Button, Col, Form, Row} from "react-bootstrap";
import LeftMenuAdmin from "./LeftMenuAdmin";
import axios from "axios";
import {jwtDecode} from "jwt-decode";

function AddWorkGroup(props) {

    const [nameWorkGroup, setNameWorkGroup] = useState("");
    const [description, setDescription] = useState("");
    function handleGroupWork() {
    const url="http://localhost:8080/api/v1/admin/addGroupWork"
        console.log(nameWorkGroup)
        console.log(description)
        axios.post(url, {
            name: nameWorkGroup,
            description:  description
        }, {headers: {
            "Authorization": "Bearer "+localStorage.getItem("token")
            }})
            .then(function (response) {

            })
            .catch(function (error) {
                alert("ERROR OUR")
            })
    }

    return (
        <Row>
            <Col sm={2}><LeftMenuAdmin/></Col>
            <Col sm={10}>
                <Form>
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label>Name WorkGroup</Form.Label>
                        <Form.Control type="text" placeholder="Enter Name Group Work" onChange={(e) => setNameWorkGroup(e.target.value)}/>
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="formBasicPassword">
                        <Form.Label>Description</Form.Label>
                        <Form.Control type="text" placeholder="Enter Description" onChange={(e) => setDescription(e.target.value)}/>
                    </Form.Group>
                    <Button variant="primary" onClick={handleGroupWork}>
                        Add Group Work
                    </Button>
                </Form>
            </Col>

        </Row>
    );
}

export default AddWorkGroup;