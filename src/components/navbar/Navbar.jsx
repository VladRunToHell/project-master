import React, { useState } from "react";
import person from '../../assets/person.svg';
import logo from '../../assets/logo.svg'
import './navbar.css'
import {Button, Modal, Form, ButtonGroup, ToggleButton} from 'react-bootstrap'

function ToggleButtonExample() {
  const [radioValue, setRadioValue] = useState('1');

  const radios = [
    { name: 'Я мужчина', value: '1' },
    { name: 'Я женщина', value: '2' },
  ];

  return (
    <>
      <ButtonGroup>
        {radios.map((radio, idx) => (
          <ToggleButton
            key={idx}
            id={`radio-${idx}`}
            type="radio"
            variant={'outline-danger'}
            name="radio"
            value={radio.value}
            checked={radioValue === radio.value}
            onChange={(e) => setRadioValue(e.currentTarget.value)}
          >
            {radio.name}
          </ToggleButton>
        ))}
      </ButtonGroup>
    </>
  );
}


function MyVerticallyCenteredModal(props) {
  return (
    <Modal
      {...props}
      size="lg"
      aria-labelledby="contained-modal-title-vcenter"
      centered
    >
      <Modal.Header closeButton>
        
      </Modal.Header>
      <Modal.Body className='register-body'>
        <h4 className='register-header'>Регистрация</h4>
        <Form.Control placeholder='Ваше имя' className='form-text' />
        <Form.Control placeholder='Ваша фамилия' className='form-text' />
        <Form.Control placeholder='Дата вашего рождения' className='form-text' />
        <ToggleButtonExample></ToggleButtonExample>
        <Form.Control placeholder='Логин' className='form-text' />
        <Form.Control placeholder='Пароль' type="password" className='form-text' />
        
      </Modal.Body>
      <Modal.Footer>
        <Button variant='outline-danger' onClick={props.onHide}>Подтвердить</Button>
      </Modal.Footer>
    </Modal>
  );
}

function Register() {
  const [modalShow, setModalShow] = React.useState(false);

  return (
    <>
      <Button className='register-button' variant='outline-danger' onClick={() => setModalShow(true)}>
        Регистрация
      </Button>
      <MyVerticallyCenteredModal
        show={modalShow}
        onHide={() => setModalShow(false)}
      />
    </>
  );
}

class Navbar extends React.Component{

  render(){
    return (
      <div className='vmeste__navbar'>
        <div className='vmeste__navbar-logo'>
          
            <img src={logo} alt="logo" className='vmeste__navbar-logo_logo'/>
          
        </div>
        <div className='vmeste__navbar-login'>
          <img src={person} alt="person" className='vmeste__navbar-login_person'/>
          <p className='vmeste__navbar-login_p'>Войти</p>
          <Register id ='register'></Register>
        </div>
      </div>
    )
  }
}

export default Navbar