import { Form, Button } from 'react-bootstrap';

const ReviewForm = ({handleSubmit, reviewText, labelText, defaultValue}) => {
  return (
    
    <Form>
        <Form.Group className='mb-3' controlId='exampleForm.ControlTextArea1'>
            <Form.Label> {labelText} </Form.Label>
            <Form.Control as="textarea" rows={3} ref={reviewText} defaultValue={defaultValue}></Form.Control>
            <Button variant='outline-info' onClick={handleSubmit} style={{marginTop: '20px'}}> Submit </Button>
        </Form.Group>
    </Form>
  )
}

export default ReviewForm