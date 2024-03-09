import React, {useEffect, useState} from 'react';
import axios from "axios";
import {Button, Col, Form, Modal, Row} from "react-bootstrap";
import LeftMenuAdmin from "./LeftMenuAdmin";

function AddWorkType(props) {
    const [materials, setMaterials] = useState([]);
    const [materialsId, setMaterialsId] = useState(0);
    useEffect(() => {
        const url = "http://localhost:8080/api/v1/materials"
        axios.get(url,
            {
                headers: {

                    'Authorization': `Bearer ${localStorage.getItem("token")}`
                }

            }
        )
            .then(function (response) {
                setMaterials(response.data)
                console.log(response.data)
            })


            .catch(function (error) {
                alert("ERROR OUR")
            })
    }, [setMaterials]);
    return (
        <>
            <Row>
                <Col sm={2}><LeftMenuAdmin/></Col>
                <Col sm={10}>
                    <h1 style={{color: "royalblue"}}><b>Add Work Type</b></h1>
                    <br/>
                    <Form>
                        <Form.Group className="mb-3" controlId="formBasicSelect">
                            <Form.Label>Name Material</Form.Label>
                            <Form.Select aria-label="Default select example"
                                         onChange={(e) => setMaterialsId(e.target.value)}>

                                {
                                    materials.map(item => {
                                        return (<option key={item.id} value={item.id}>{item.name}</option>)
                                    })
                                }


                            </Form.Select>
                        </Form.Group>
                    </Form>
                </Col>

            </Row>


        </>
    );
}

export default AddWorkType;