import React, {useEffect, useState} from 'react';
import {Button, Col, Form, Modal, Row} from "react-bootstrap";
import LeftMenuAdmin from "./LeftMenuAdmin";
import axios from "axios";

function AddSubCategoryMaterial(props) {
    const [name, setName] = useState("");
    const [description, setDescription] = useState("");
    const [show, setShow] = useState(false);
    const [categories, setCategories]=useState([])
    const [category, setCategory]=useState()
    const handleClose = () => setShow(false);
    const handleShow = () => {
        setShow(true)
    };

    function handleAddSubCategoryMaterial() {
        const url = "http://localhost:8080/api/v1/admin/addSubCategoryMaterial"
        if (validate()) {
            axios.post(url, {
                name: name,
                description: description,
                categoryMaterialId :category

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
        } else {
            alert("Необходимо заполнить все поля")
        }
    }
    function validate() {
        if (name == null) return false;
        if (name.length < 1) return false;
        if (description == null) return false;
        if (description.length < 1) return false;
        return true;
    }

    useEffect(() => {
        const url = "http://localhost:8080/api/v1/public/categoryMaterial"
        axios.get(url, {
                // headers: {
                //     "Authorization": "Bearer " + localStorage.getItem("token")
                // }
            }
        )
            .then(function (response) {
                setCategories(response.data)
                setCategory(response.data[0].id)
            })
            .catch(function (error) {
               console.log(error)
            })
    }, [setCategories]);

    return (
        <>
            <Row>
                <Col sm={2}><LeftMenuAdmin/></Col>
                <Col sm={1}> </Col>
                <Col sm={9}>
                    <h1 style={{color: "royalblue"}}><b>Add SubCategory Material</b></h1>
                    <Form>
                        <Form.Group controlId="fromBasicText7">
                            <Form.Label>Category Material</Form.Label>
                            <Form.Select
                                onChange={(e => setCategory(e.target.value))}
                            >
                                {categories.map(item => {
                                    return (<option key={item.id} value={item.id}>{item.name}</option>);
                                })}
                            </Form.Select>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicName">
                            <Form.Label>Name Sub Category Material</Form.Label>
                            <Form.Control type="text" placeholder="Enter Name Sub Category Material"
                                          onChange={(e) => setName(e.target.value)}/>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicCode">
                            <Form.Label>Description Sub Category</Form.Label>
                            <Form.Control type="text" placeholder="Enter Description Sub Category"
                                          onChange={(e) => setDescription(e.target.value)}/>
                        </Form.Group>

                        <br/>
                        <Button variant="primary" onClick={handleAddSubCategoryMaterial}>
                            Add Sub Category Material
                        </Button>
                    </Form>
                </Col>
            </Row>
            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Материал добавлен успешно</Modal.Title>
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

export default AddSubCategoryMaterial;