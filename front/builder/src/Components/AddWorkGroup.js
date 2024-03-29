import React, {useState} from 'react';
import {Button, Col, Form, Modal, Row} from "react-bootstrap";
import LeftMenuAdmin from "./LeftMenuAdmin";
import axios from "axios";

function AddWorkGroup(props) {

    const [name, setName] = useState("");
    const [description, setDescription] = useState("");
    const [show, setShow] = useState(false);
    const [file, setFile] = useState();
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    function handleGroupWork(e) {
        e.preventDefault()
        const url = 'http://localhost:8080/api/v1/admin/addGroupWork';
        if (validate()){
            axios.post(url, {
                name: name,
                description: description,
                file:file
            }, {
                headers: {
                    'content-type': 'multipart/form-data',
                    'Authorization': `Bearer ${localStorage.getItem("token")}`
                }
            }).then(resp => console.log(resp))
                .catch(err=>alert("Такая категория уже существует"))
        } else {alert("Необходимо заполнить все поля")}
    }

    function validate(){
        console.log(name)
        if(name==null) return false;
        if(name.length<1) return false;
        console.log(description)
        if(description==null) return false;
        if(description.length<1) return false;
        console.log(file)
        if(file==null) return false;
        return true;
    }

    return (
        <>
            <Row>
                <Col sm={2}><LeftMenuAdmin/></Col>
                <Col sm={10}>
                    <h1 style={{color: "blueviolet"}}><b>Add Work Group</b></h1>
                    <br/>
                    <Form>
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label>Name WorkGroup</Form.Label>
                            <Form.Control type="text" placeholder="Enter Name Group Work"
                                          onChange={(e) => setName(e.target.value)}/>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicPassword">
                            <Form.Label>Description</Form.Label>
                            <Form.Control type="text" placeholder="Enter Description"
                                          onChange={(e) => setDescription(e.target.value)}/>
                        </Form.Group>
                        <Form.Group controlId="fromBasicImageWorkGroup">
                            <Form.Label>Image</Form.Label>
                            <Form.Control type="file" placeholder="Image"
                                          onChange={(e) =>setFile(e.target.files[0])}
                            />
                        </Form.Group>
                        <br/>
                        <Button variant="primary" onClick={handleGroupWork}>
                            Add Group Work
                        </Button>
                    </Form>
                </Col>

            </Row>

            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Группа добавлена успешно</Modal.Title>
                </Modal.Header>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Close
                    </Button>
                </Modal.Footer>
            </Modal>
        </>
    );
}

export default AddWorkGroup;