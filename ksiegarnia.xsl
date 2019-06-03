<?xml version="1.0" encoding="UTF-8"?>
<xs:stylesheet version="2.0" xmlns:xs="http://www.w3.org/1999/XSL/Transform">
    <xs:template match="/">
        <html>
            <head>
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous" />


            </head>

            <body>
                <div class="container">
                    <h1>Autorzy</h1>
                    <table class="table table-striped table-hover table-sm">
                        <thead>
                            <tr>
                                <th scope="col">AutorId</th>
                                <th scope="col">Imie</th>
                                <th scope="col">Nazwisko</th>
                            </tr>
                        </thead>
                        <tbody>

                            <xs:for-each select="ksiegarnia/autorzy/autor">
                                <xs:sort select="ksiegarnia/autorzy/autor/@autorId"/>
                                <xs:choose>
                                    <xs:when test="string-length(nazwisko) &gt; 8">
                                        <tr>
                                            <td><font color="red"><xs:value-of select="@autorId" /></font></td>
                                            <td><font color="red"><xs:value-of select="imie" /></font></td>
                                            <td><font color="red"><xs:value-of select="nazwisko" /></font></td>
                                        </tr>
                                    </xs:when>
                                    <xs:otherwise>
                                        <tr>
                                            <td><xs:value-of select="@autorId" /></td>
                                            <td><xs:value-of select="imie" /></td>
                                            <td><xs:value-of select="nazwisko" /></td>
                                        </tr>
                                    </xs:otherwise>
                                </xs:choose>

                            </xs:for-each>
                        </tbody>
                    </table>

                    <h1>Stanowiska</h1>

                    <table class="table table-striped table-hover table-sm">
                        <thead>
                            <tr>
                                <th scope="col">StanowiskoId</th>
                                <th scope="col">Nazwa stanowiska</th>
                                <th scope="col">Pensja</th>
                            </tr>
                        </thead>
                        <tbody>

                            <xs:for-each select="ksiegarnia/stanowiska/stanowisko">
                                <xs:sort select="pensja" order="descending"/>
                                <tr>
                                    <td><xs:value-of select="@stanowiskoId" /></td>
                                    <td><xs:value-of select="nazwaStanowiska" /></td>
                                    <td><xs:value-of select="pensja" /></td>
                                </tr>
                            </xs:for-each>
                        </tbody>
                    </table>
                    <h1>Ksiazki</h1>

                    <table class="table table-striped table-hover table-sm">
                        <thead>
                            <tr>
                                <th scope="col">Nazwa ksiazki</th>
                                <th scope="col">Autor</th>
                                <th scope="col">Cena</th>
                                <th scope="col">Liczba stron</th>
                                <th scope="col">Wydawnictwo</th>
                                <th scope="col">Rok wydania</th>
                            </tr>
                        </thead>
                        <tbody>

                            <xs:for-each select="ksiegarnia/produkty/ksiazki/ksiazka">
                                <xs:sort select="nazwaKsiazki"/>
                                <tr>
                                    <td><xs:value-of select="nazwaKsiazki" /></td>
                                    <td><xs:value-of select="autorId/@refid" /></td>
                                    <td><xs:value-of select="cena" />&#160;<xs:value-of select="cena/@currency" /></td>
                                    <td><xs:value-of select="liczbaStron" /></td>
                                    <td><xs:value-of select="wydawnictwo" /></td>
                                    <td><xs:value-of select="rokWydania" /></td>

                                </tr>
                            </xs:for-each>
                        </tbody>
                    </table>

                    <h1>Gry</h1>

                    <table class="table table-striped table-hover table-sm">
                        <thead>
                            <tr>
                                <th scope="col">Nazwa gry</th>
                                <th scope="col">cena</th>
                            </tr>
                        </thead>
                        <tbody>

                            <xs:for-each select="ksiegarnia/produkty/gry/gra">
                                <tr>
                                    <td><xs:value-of select="nazwaGry" /></td>
                                    <td><xs:value-of select="cena" />&#160;<xs:value-of select="cena/@currency" /></td>
                                </tr>
                            </xs:for-each>
                        </tbody>
                    </table>
                    <h1>Zeszyty</h1>

                    <table class="table table-striped table-hover table-sm">
                        <thead>
                            <tr>
                                <th scope="col">Nazwa gry</th>
                                <th scope="col">Ilosc kartek</th>
                                <th scope="col">cena</th>
                            </tr>
                        </thead>
                        <tbody>

                            <xs:for-each select="ksiegarnia/produkty/zeszyty/zeszyt">
                                <tr>
                                    <td><xs:value-of select="nazwaZeszytu" /></td>

                                    <xs:choose>
                                        <xs:when test="iloscKartek &gt; 100">
                                            <td><b><xs:value-of select="iloscKartek" /></b></td>
                                        </xs:when>
                                        <xs:otherwise>
                                            <td><xs:value-of select="iloscKartek" /></td>
                                        </xs:otherwise>
                                    </xs:choose>
                                    <td><xs:value-of select="cena" />&#160;<xs:value-of select="cena/@currency" /></td>
                                </tr>
                            </xs:for-each>
                        </tbody>
                    </table>
                    <h1>Dlugopisy</h1>

                    <table class="table table-striped table-hover table-sm">
                        <thead>
                            <tr>
                                <th scope="col">Kolor</th>
                                <th scope="col">cena</th>
                            </tr>
                        </thead>
                        <tbody>

                            <xs:for-each select="ksiegarnia/produkty/dlugopisy/dlugopis">
                                <tr>
                                    <td><xs:value-of select="kolor" /></td>
                                    <td><xs:value-of select="cena" />&#160;<xs:value-of select="cena/@currency" /></td>
                                </tr>
                            </xs:for-each>
                        </tbody>
                    </table>

                    <h1>Pracownicy</h1>

                    <table class="table table-striped table-hover table-sm">
                        <thead>
                            <tr>
                                <th scope="col">Imie</th>
                                <th scope="col">Nazwisko</th>
                                <th scope="col">Stanowisko</th>
                                <th scope="col">PESEL</th>
                                <th scope="col">Data zatrudnienia</th>
                                <th scope="col">Narodowosc</th>
                            </tr>
                        </thead>
                        <tbody>

                            <xs:for-each select="ksiegarnia/pracownicy/pracownik">

                                <tr>
                                    <td><xs:value-of select="imie" /></td>
                                    <td><xs:value-of select="nazwisko" /></td>
                                    <td><xs:value-of select="stanowiskoId/@refid" /></td>
                                    <td><xs:value-of select="pesel" /></td>
                                    <td><xs:value-of select="dataZatrudnienia" /></td>
                                    <td><xs:value-of select="@narodowosc" /></td>
                                </tr>
                            </xs:for-each>
                        </tbody>
                    </table>


                </div>
            </body>
        </html>
    </xs:template>


</xs:stylesheet>