import React, { useState } from "react";
import UrlForm from "../components/UrlForm";
import { Flex } from "@chakra-ui/react";
import Result from "../components/Result";

export default function Home() {
  const [shorturl, setShorturl] = useState('');

  const resetForm = () => {
    setShorturl("")
  };

  return (
    <Flex height="100vh" alignItems="center" justifyContent="center">
      <Flex width="50vw" background="#f7f7f7" p="20" rounded="10">
        {
          shorturl
          ? <Result shorturl={ shorturl } resetForm={ resetForm } />
          : <UrlForm setShorturl={ setShorturl } />
        }
      </Flex>
    </Flex>
  )
}
