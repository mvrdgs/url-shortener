import React from 'react';
import { Button, Flex, Input, useClipboard } from '@chakra-ui/react';

function Result({ shorturl, resetForm }) {
  const { hasCopied, onCopy } = useClipboard(shorturl)

  return (
    <Flex width="100%" direction="column" alignItems="center" justifyContent="center">
      <Flex width="100%" alignItems="center" justifyContent="center">
        <Input value={ shorturl } isReadOnly background="white" />
        <Button
          onClick={ onCopy }
          m="2"
          background="linear-gradient(90deg,rgba(152,193,76,1) 0%,rgba(103,184,91,1) 100%)"
          variant="outline"
          color="white"
          width="100px"
        >
          { hasCopied ? "Copiado!" : "Copiar" }
        </Button>
      </Flex>
      <Button
        onClick={ resetForm }
        background="linear-gradient(90deg,rgba(152,193,76,1) 0%,rgba(103,184,91,1) 100%)"
        variant="outline"
        color="white"
        width="100px"
        mt="10"
      >
        Retornar
      </Button>
    </Flex>
  );
}

export default Result;