import React, {useEffect, useState} from 'react';
import axios from "axios";
import {Button, Col, Form, Modal, Row} from "react-bootstrap";
import LeftMenuAdmin from "./LeftMenuAdmin";

function AddSubWorkGroup(props) {
    const [nameSubWorkGroup, setNameSubWorkGroup] = useState("");
    const [description, setDescription] = useState("");
    const [show, setShow] = useState(false);
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const [workGroups, setWorkGroups] = useState([]);
    const [workGroupsID, setWorkGroupsID] = useState();
    useEffect(() => {
        const url = "http://localhost:8080/api/v1/public/workGroup"
        axios.get(url)
            .then(function (response) {
                setWorkGroups(response.data)
                setWorkGroupsID(response.data[0].id)
            })

            .catch(function (error) {
                alert("ERROR OUR")
            })
    }, [setWorkGroups]);


    function handleSubGroupWork() {
        const url = "http://localhost:8080/api/v1/admin/addSubGroupWork"
        if(validate()) {
            axios.post(url, {
                name: nameSubWorkGroup,
                description: description,
                workGroupsId: workGroupsID
            }, {
                headers: {
                    "Authorization": "Bearer " + localStorage.getItem("token")
                }
            })
                .then(function (response) {
                    handleShow()
                })
                .catch(function (error) {
                    alert("ERROR OUR")
                })
        }
        else {alert("Необходимо заполнить все поля")}
    }

    function validate() {
        if (nameSubWorkGroup == null) return false;
        if (nameSubWorkGroup.length < 1) return false;
        if (description == null) return false;
        if (description.length < 1) return false;
        return true;
    }

    return (
        <>
            <Row>
                <Col sm={2}><LeftMenuAdmin/></Col>
                <Col sm={10}>
                    <h1 style={{color: "royalblue"}}><b>Add Sub Work Group</b></h1>
                    <br/>
                    <Form>
                        <Form.Group className="mb-3" controlId="formBasicSelect">
                            <Form.Label>Name WorkGroup</Form.Label>
                            <Form.Select aria-label="Default select example"
                                         onChange={(e) => setWorkGroupsID(e.target.value)}>

                                {
                                    workGroups.map(item => {
                                        return (<option key={item.id} value={item.id}>{item.name}</option>)
                                    })
                                }


                            </Form.Select>
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label>Name Sub WorkGroup</Form.Label>
                            <Form.Control type="text" placeholder="Enter Name Sub Group Work"
                                          onChange={(e) => setNameSubWorkGroup(e.target.value)}/>
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="formBasicPassword">
                            <Form.Label>Description</Form.Label>
                            <Form.Control type="text" placeholder="Enter Description"
                                          onChange={(e) => setDescription(e.target.value)}/>
                        </Form.Group>
                        <Button variant="primary" onClick={handleSubGroupWork}>
                            Add Sub Group Work
                        </Button>
                    </Form>
                </Col>

            </Row>

            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Подгруппа добавлена успешно</Modal.Title>
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

export default AddSubWorkGroup;

