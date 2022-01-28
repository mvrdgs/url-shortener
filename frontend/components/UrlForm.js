import React, { useState } from 'react';
import { Button, Flex, Input, Text } from "@chakra-ui/react";
import styles from '../styles/index.module.css';
import Loading from './Loading';

const errorMap = {
  400: 'Url inválida',
};

function UrlForm({ setShorturl }) {
  const [input, setInput] = useState('');
  const [error, setError] = useState('');
  const [isLoading, setLoading] = useState(false);
  const pathname = typeof(window) !== 'undefined' && window.location.href;

  const handleInput = ({ target }) => {
    const { value } = target;
    setError('')
    setInput(value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);

    try {
      const res = await fetch('http://localhost:8080', {
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        method: 'POST',
        body: JSON.stringify({ url: input}),
      });

      if (res.status === 200) {
        const { shortUrl } = await res.json();
        setShorturl(`${pathname}${shortUrl}`)
      } else {
        setError(errorMap[res.status]);
        setLoading(false);
      }      
    } catch (error) {
      setError('Erro inesperado');
      setLoading(false);
    }
  };

  return (
    <Flex direction="column" width="100%" alignItems="center">
      {
        isLoading
        ? <Loading />
        : (
          <>
            <form
              onSubmit={ handleSubmit }
              background="red"
              className={ styles.form }
            >
              <Input
                type="text"
                placeholder="Insira o link"
                value={ input }
                onChange={ handleInput }
                backgroundColor="white"
                size="lg"
                width="100%"
              />
              <Button
                onClick={ handleSubmit }
                m="2"
                background="linear-gradient(90deg,rgba(152,193,76,1) 0%,rgba(103,184,91,1) 100%)"
                variant="outline"
                color="white"
              >
                Encurtar
              </Button>
            </form>
            <Text color="red" mt="6" height="1rem">
              { error }
            </Text>
          </>
        )
      }
    </Flex>
  );
}

export default UrlForm;