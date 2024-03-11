import React, {useEffect, useState} from 'react';
import axios from "axios";
import {Button, Col, Form, Modal, Row} from "react-bootstrap";
import LeftMenuAdmin from "./LeftMenuAdmin";
import DataTable from 'react-data-table-component'
import {Input} from "@mui/material";


function AddWorkType(props) {
    const [materials, setMaterials] = useState([]);
    const [workGroups, setWorkGroups] = useState([]);
    const [subWorkGroups, setSubWorkGroups] = useState([]);

    const [workGroupId, setWorkGroupId] = useState(0);
    const [subWorkGroupId, setSubWorkGroupId] = useState(0);
    const [qnt, setQnt] = useState()
    const [showAddMaterial, setShowAddMaterial] = useState(false)
    const [selectedData, setSelectedData] = React.useState([]);


    const columns = [
        {name: "ID", selector: row => row.id, sortable: true},
        {name: "Name", selector: row => row.name, sortable: true},
        {name: "Code", selector: row => row.code, sortable: true},
        {name: "Measurement Type", selector: row => row.measurementType, sortable: true},
        {name: "Price", selector: row => row.price, sortable: true},
        {
            name: "Quantity",selector: row => row.qnt, input: true, cell: row => <Input type='number' min="0" step="0.01" placeholder="Enter qnt"
                                                              onChange={
                (e) =>{
                    row.qnt=e.target.value
                    materials.map(el=>el.id===row.id ? el.qnt=row.qnt : el )
                    console.log(materials)
                }
            }
            />
        }

    ]

    let materialId
    let nameMaterial;
    let measurementType;
    let price;
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
    useEffect(() => {
        const url = "http://localhost:8080/api/v1/public/workGroup"
        axios.get(url)
            .then(function (response) {
                setWorkGroups(response.data)
                console.log(response.data)
                console.log(response.data[0].id)
                handleSubWorkGroupByWorkGroup(response.data[0].id)
            })
            .catch(function (error) {
                alert("ERROR OUR")
            })
    }, [setWorkGroups]);

    function handleSubWorkGroupByWorkGroup(byWorkGroupId) {

        const url = 'http://localhost:8080/api/v1/public/workGroup/' + byWorkGroupId;


        axios.get(url)
            .then(function (response) {

                console.log(response.data)
                setSubWorkGroups(response.data)
            })
            .catch(function (error) {
                alert("ERROR OUR")
            })

    }

    function handleAdd() {
            console.log(selectedData)

        const url = 'http://localhost:8080/api/v1/admin/addWorkType';

            axios.post(url, {
                materials: selectedData
            }, {
                headers: {
                    'Authorization': `Bearer ${localStorage.getItem("token")}`
                }
            }).then(resp => console.log(resp))
                .catch(err=>alert("Такая категория уже существует"))

    }

    function handleCloseAddMaterial() {
        setShowAddMaterial(false)
    }

    function handleShowAddMaterial() {
        setShowAddMaterial(true)
    }
    const handleSelected = ({selectedRows}) => {
        setSelectedData(selectedRows);
        console.log({selectedRows});
    };

    return (
        <>
            <Row>
                <Col sm={2}><LeftMenuAdmin/></Col>
                <Col sm={10}>
                    <h1 style={{color: "royalblue"}}><b>Add Work Type</b></h1>
                    <br/>
                    <Form>
                        <Form.Group className="mb-3" controlId="formBasicSelect1">
                            <Form.Label>Name Work Group</Form.Label>
                            <Form.Select aria-label="Default select example"
                                         onChange={(e) => {
                                             setWorkGroupId(e.target.value)
                                             handleSubWorkGroupByWorkGroup(e.target.value)
                                         }}>
                                {
                                    workGroups.map(item => {
                                        return (<option key={item.id} value={item.id}>{item.name}</option>)
                                    })
                                }
                            </Form.Select>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicSelect3">
                            <Form.Label>Name Sub Work Group</Form.Label>
                            <Form.Select aria-label="Default select example"
                                         onChange={(e) => setSubWorkGroupId(e.target.value)}>
                                {
                                    subWorkGroups.map(item => {
                                        return (<option key={item.id} value={item.id}>{item.name}</option>)
                                    })
                                }
                            </Form.Select>
                        </Form.Group>
                        <Button variant="primary" onClick={(e) => {
                            handleShowAddMaterial()
                        }}>Add material</Button>

                    </Form>
                </Col>

            </Row>
            <Modal show={showAddMaterial} onHide={handleCloseAddMaterial} size={"xl"}>
                <Modal.Header closeButton>
                    <Modal.Title>Add Material </Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <DataTable
                        columns={columns}
                        data={materials}
                        selectableRows
                        onSelectedRowsChange={handleSelected}
                        fixedHeader
                        pagination>
                    </DataTable>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant='primary' onClick={handleAdd}>Add</Button>
                </Modal.Footer>
            </Modal>

        </>
    );
}

export default AddWorkType;