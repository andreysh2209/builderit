import React from 'react';
import {Carousel} from "react-bootstrap";
import firstImg from "../asserts/01.png";
import secondImg from "../asserts/02.jfif";
import thirdImg from "../asserts/03.jfif";


function Slider(props) {
    return (
        <Carousel>
            <Carousel.Item>
                <img className="d-block w-100" alt="Not found" src={firstImg} height="400" width="500"/>
                <Carousel.Caption>
                    <h3>First slide label</h3>
                    <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                </Carousel.Caption>
            </Carousel.Item>
            <Carousel.Item>
                <img className="d-block w-100" alt="Not found" src={secondImg} height="400" width="500"/>
                <Carousel.Caption>
                    <h3>Second slide label</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                </Carousel.Caption>
            </Carousel.Item>
            <Carousel.Item>
                <img className="d-block w-100" alt="Not found" src={thirdImg} height="400" width="500"/>
                <Carousel.Caption>
                    <h3>Third slide label</h3>
                    <p>
                        Praesent commodo cursus magna, vel scelerisque nisl consectetur.
                    </p>
                </Carousel.Caption>
            </Carousel.Item>
        </Carousel>
    );
}

export default Slider;